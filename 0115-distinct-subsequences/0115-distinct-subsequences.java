class Solution {
    private HashMap<Pair<Integer, Integer>, Integer> memo;
    
    public int numDistinct(String s, String t) {
        memo = new HashMap<>();
        return distinct(s, t, 0, 0);
    }
    
    private int distinct(String s, String t, int i, int j) {
        int m = s.length(), n = t.length();
        if (i == m || j == n || m - i < n - j)
            return j == t.length() ? 1 : 0;
        Pair<Integer, Integer> key = new Pair<>(i, j);
        if (memo.containsKey(key))
            return memo.get(key);
        int result = distinct(s, t, i + 1, j);
        if (s.charAt(i) == t.charAt(j))
            result += distinct(s, t, i + 1, j + 1);
        memo.put(key, result);
        return result;
    }
}