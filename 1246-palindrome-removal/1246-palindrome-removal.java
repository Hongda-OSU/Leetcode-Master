class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++)
                dp[i][j] = 0;
        }
        for (int len = 1; len <= n; len++) {
            for (int i = 0, j = len - 1; j < n; i++, j++) {
                if (len == 1)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = 1 + dp[i + 1][j];
                    if (arr[i] == arr[i + 1]) 
                        dp[i][j] = Math.min(1 + dp[i + 2][j], dp[i][j]);
                    for (int k = i + 2; k <= j; k++) {
                        if (arr[i] == arr[k])
                            dp[i][j] = Math.min(dp[i + 1][k - 1] + dp[k + 1][j], dp[i][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}