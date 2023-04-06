class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length, n = mat[0].length, max = 0;
        if (m == 0)
            return max;
        int[][][] dp = new int[m][n][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    continue;
                for (int k = 0; k < 4; k++)
                    dp[i][j][k] = 1;
                if (j > 0)
                    dp[i][j][0] += dp[i][j - 1][0]; // horizontal line
                if (j > 0 && i > 0)
                    dp[i][j][1] += dp[i-1][j-1][1]; // anti-diagonal line
                if (i > 0)
                    dp[i][j][2] += dp[i-1][j][2]; // vertical line
                if (j < n - 1 && i > 0)
                    dp[i][j][3] += dp[i-1][j+1][3]; // diagonal line
                max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
                max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
            }
        }
        return max;
    }
}