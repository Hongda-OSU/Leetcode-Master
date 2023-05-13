class Solution {
    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        int mod = (int) 1e9 + 7;
        dp[0][0] = 1L;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++)
                dp[i][j] = (dp[i - 1][j] * (long)(i - 1) + dp[i - 1][j - 1]) % mod;
        }
        return (int)(dp[n][k] % mod);
    }
}