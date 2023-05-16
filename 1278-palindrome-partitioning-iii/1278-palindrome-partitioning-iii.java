class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int p = 0; p < n; p++) {
            for (int i = 0, j = p; j < n; i++, j++) {
                if (p == 0)
                    dp[i][j] = 0;
                else if (p == 1) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = 0;
                    else 
                        dp[i][j] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = dp[i + 1][j - 1];
                    else 
                        dp[i][j] = 1 + dp[i + 1][j - 1];
                }
            }
        }
        return helper(dp, s, n, k, new Integer[n + 1][k + 1]);
    }
    
    private int helper(int[][] dp, String str, int end, int k, Integer[][] memo) {
        if (k == end)
            return 0;
        if (k == 1)
            return dp[0][end - 1];
        if (memo[end][k] != null)
            return memo[end][k];
        int result = Integer.MAX_VALUE;
        for (int i = k - 1; i < end; i++)
            result = Math.min(result, helper(dp, str, i, k - 1, memo) + dp[i][end - 1]);
        return memo[end][k] = result;
    }
}