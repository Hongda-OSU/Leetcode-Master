class Solution {
    int index = 0;
    public int calculate(String s) {
        int number = 0; /// Current number
        char sign = '+';
        /// Stack to track current state of equation calculations
        Stack<Integer> stack = new Stack<>();
        while(index <= s.length()) {
            char curr = (index == s.length()) ? '#': s.charAt(index);
            if(curr == '(') {
                index++;
                /// Start Of Braces - Ask current function to get result until end of Braces i.e. ")"
                number = calculate(s);
            } else if(curr == ')') {
                /// End of Braces - Update Stack and return the current result
                updateStack(stack, number, sign);
                return getResult(stack);
            } else {
                /// if current character is a number append it to existing one
                if(Character.isDigit(curr)) number = (number * 10) + curr - '0';
                else { /// evalute here 
                    updateStack(stack, number, sign);
                    sign = curr;
                    number = 0;
                }
            }
            index++;
        }
        //// Finally Calculate based on numbers present on Stack
        return getResult(stack);
    }
    
    
    //// Helper to update current Stack with provided number and Sign
    private void updateStack(Stack<Integer> stackInst, int number, char sign) {
        switch(sign) {
            case '+': stackInst.push(number); break;
            case '-': stackInst.push(-number); break;
            case '*': stackInst.push(stackInst.pop() * number); break;
            case '/': stackInst.push(stackInst.pop() / number); break;   
        }
    }
    
    //// Add up all number from existing Stack to get result
    private int getResult(Stack<Integer> stackInst) {
        int res = 0;
        while(!stackInst.isEmpty()) res += stackInst.pop();
        return res;
    }
}