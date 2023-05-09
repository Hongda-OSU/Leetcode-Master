class Solution {
    private int index = 0;
    
    public int calculate(String s) {
        int number = 0, len = s.length();
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        while (index <= len) {
            char curr = (index == len) ? '#' : s.charAt(index);
            if (curr == '(') {
                index++;
                number = calculate(s);
            } else if (curr == ')') {
                updateStack(stack, number, sign);
                return getResult(stack);
            } else {
                if (Character.isDigit(curr))
                    number = (number * 10) + curr - '0';
                else {
                    updateStack(stack, number, sign);
                    sign = curr;
                    number = 0;
                }
            }
            index++;
        }
        return getResult(stack);
    }
    
    private void updateStack(Stack<Integer> stack, int number, char sign) {
        switch(sign) {
            case '+': stack.push(number); break;
            case '-': stack.push(-number); break;
            case '*': stack.push(stack.pop() * number); break;
            case '/': stack.push(stack.pop() / number); break;   
        }
    }
    
    private int getResult(Stack<Integer> stack) {
        int result = 0;
        while (!stack.isEmpty())
            result += stack.pop();
        return result;
    }
}