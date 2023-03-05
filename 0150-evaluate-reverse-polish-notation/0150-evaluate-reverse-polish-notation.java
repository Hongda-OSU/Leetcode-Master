class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                int right = dq.removeFirst();
                int left = dq.removeFirst();
                if (token.equals("*"))
                    dq.addFirst(left * right);
                else if (token.equals("/"))
                    dq.addFirst(left / right);
                else if (token.equals("+"))
                    dq.addFirst(left + right);
                else
                    dq.addFirst(left - right);
            } else {
                dq.addFirst(Integer.valueOf(token));
            }
        }
        return dq.peekFirst();
    }
}