class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == 'I') {
                stack.push(i);
                while (!stack.isEmpty()) {
                    result[j++] = stack.pop();
                }
            } else {
                stack.push(i);
            }
        }
        stack.push(n + 1);
        
        while (!stack.isEmpty()) 
            result[j++] = stack.pop();
        return result;
    }
}