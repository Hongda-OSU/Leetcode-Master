class Solution {
    private HashMap<String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression))
            return map.get(expression);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (Integer c1 : left) {
                    for (Integer c2 : right) {
                        if (ch == '+')
                            result.add(c1 + c2);
                        else if (ch == '-')
                            result.add(c1 - c2);
                        else if (ch == '*')
                            result.add(c1 * c2);
                    }
                }
            }
        }
        if (result.size() == 0)
            result.add(Integer.parseInt(expression));
        map.put(expression, result);
        return result;
    }
}