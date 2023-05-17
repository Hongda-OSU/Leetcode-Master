class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int k = 1; k <= n; k++) {
            for (int l = 0; l <= n - k; l++) {
                int r = l + k - 1;
                int j = -1;
                dp[l][r] = n;
                for (int i = l; i < r; i++) {
                    if (s.charAt(i) != s.charAt(r) && j == -1) {
                        j = i;
                    }
                    if (j != -1) {
                        dp[l][r] = Math.min(dp[l][r], 1 + dp[j][i] + dp[i + 1][r]);
                    }
                }
                if (j == -1) {
                    dp[l][r] = 0;
                }
            }
        }
        return dp[0][n - 1] + 1;
    }
}