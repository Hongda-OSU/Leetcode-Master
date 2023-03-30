class Solution {
    public Map<String, List<Integer>> memo;
    
    public List<Integer> diffWaysToCompute(String expression) {
        memo = new HashMap<>();
        int len = expression.length();
        List<Integer> result = memo.get(expression);
        if (result != null)
            return result;
        result = new ArrayList<>();
        if (isDigit(expression)) {
            result.add(Integer.parseInt(expression));
            memo.put(expression, result);
            return result;
        }
        for (int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, len));
                for (Integer num1 : left) {
                    for (Integer num2 : right) {
                        switch (ch) {
                            case '+':
                                result.add(num1 + num2);
                                break;
                            case '-':
                                result.add(num1 - num2);
                                break;
                            case '*':
                                result.add(num1 * num2);
                                break;
                        }
                    }
                }
            }
        }
        memo.put(expression, result);
        return result;
    }
    
    public boolean isDigit(String str) {
        for (Character ch : str.toCharArray()) {
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }
}