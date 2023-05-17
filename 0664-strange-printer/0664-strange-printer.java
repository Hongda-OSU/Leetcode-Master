class Solution {
    int dp[][];

    private int f(String s, int n, int l, int r) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        dp[l][r] = n;
        int j = -1;
        for (int i = l; i < r; i++) {
            if (s.charAt(i) != s.charAt(r) && j == -1) {
                j = i;
            }
            if (j != -1) {
                dp[l][r] = Math.min(dp[l][r], 1 + f(s, n, j, i) + f(s, n, i + 1, r));
            }
        }
        if (j == -1) {
            dp[l][r] = 0;
        }
        return dp[l][r];
    }

    public int strangePrinter(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int l = 0; l < n; l++) {
            for (int r = 0; r < n; r++) {
                dp[l][r] = -1;
            }
        }
        return f(s, n, 0, n - 1) + 1;
    }
}