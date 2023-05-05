class Solution {
    private int index;
    
    public int calculate(String s) {
        index = 0;
        return calculator(s);
    }
    
    private int calculator(String str) {
        int result = 0, num = 0, sign = 1;
        while (index < str.length()) {
            char ch = str.charAt(index++);
            if (ch >= '0' && ch <= '9')
                num = num * 10 + ch - '0';
            else if (ch == '(')
                num = calculator(str);
            else if (ch == ')')
                return result + sign * num;
            else if (ch == '+' || ch == '-') {
                result += sign * num;
                num = 0;
                sign = ch == '-' ? -1 : 1;
            }
        }
        return result + sign * num;
    }
}