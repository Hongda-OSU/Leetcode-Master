class Solution {

    private int[][] dir = {{ -1, 0}, {0, -1}, { -1, -1}, { -1, 1}};

    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int m = M.length, n = M[0].length;

        int max = 0;
        int[][][] dp = new int[m + 1][n + 2][4];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (M[i - 1][j - 1] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = dp[i + dir[k][0]][j + dir[k][1]][k] + 1;
                    max = Math.max(max, dp[i][j][k]);
                }
            }
        }
        return max;
    }
}