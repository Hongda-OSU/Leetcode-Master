class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0";
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > ch) {
                stack.removeLast();
                k--;
            }
            stack.addLast(ch);
        }
        while (k > 0) {
            stack.removeLast();
            k--;
        }
        while (!stack.isEmpty() && stack.peekFirst() == '0')
            stack.removeFirst();
        if (stack.isEmpty())
            return "0";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.removeFirst());
        return sb.toString();
    }
}