class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        int len = s.length();
        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                String str = s.substring(j, i + 1);
                if (wordDict.contains(str) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    } 
}