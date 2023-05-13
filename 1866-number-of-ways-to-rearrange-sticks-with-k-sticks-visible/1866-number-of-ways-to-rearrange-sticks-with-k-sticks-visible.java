class Solution {
    public int rearrangeSticks(int n, int k) {
        //Let's use DP to solve, dp[i][j]: we have i sticks and j left visible
        //imagine for i+1, we add a smallest stick into the group
        //so for dp[i+1][j],when we put this smallest stick not in the first place, 
        //this stick will have no impact on left visible
        //and there are i places to put, so i * dp[i][j]
        //when this smallest stick is put in the first place, then we can only have j-1 visible for the remaining
        //so dp[i][j-1]
        //dp[i+1][j] = dp[i][j] * i + dp[i][j-1]
        //dp[0][0] = 1
        long[][] dp = new long[n+1][k+1];
        dp[0][0] = 1L;
        int mod = (int)(1e9+7);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = dp[i-1][j] * (long)(i-1)+ dp[i-1][j-1];
                dp[i][j] %= mod;
            }
        }
        return (int)(dp[n][k] % mod);
    }
}