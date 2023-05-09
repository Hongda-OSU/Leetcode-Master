class Solution {
    public int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = 0;
        char op = '+';
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '+', '-', '*', '/' -> {
                    eval(stack, n, op);
                    op = ch;
                    n = 0;
                }
                case ' ' -> {}
                default -> n = n * 10 + (ch - '0');
            }
        }
        eval(stack, n, op);
        int result = 0;
        while (!stack.isEmpty())
            result += stack.pop();
        return result;
    }
    
    private void eval(ArrayDeque<Integer> stack, int n, char op) {
        switch (op) {
            case '-' -> stack.push(-n);
            case '*' -> stack.push(stack.pop() * n);
            case '/' -> stack.push(stack.pop() / n);
            default -> stack.push(n);
        }
    }
}