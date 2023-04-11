class Solution {
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length < 2)
            return 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            while (!stack.isEmpty() && stack.peek() < num) {
                int mid = stack.pop();
                if (stack.isEmpty())
                    result += mid * num;
                else
                    result += mid * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        while(stack.size() > 1)
            result += stack.pop() * stack.peek();
        return result;
    }
}