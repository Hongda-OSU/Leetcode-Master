class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
                currentNumber = (currentNumber * 10) + (ch - '0');
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length() - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = operation == '+' ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = ch;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
}