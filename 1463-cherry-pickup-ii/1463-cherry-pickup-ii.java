class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid[0].length;
        int[][] dp = new int[n][n], tmp = new int[n][n];
        for (int r = grid.length - 1; r >= 0; r--) {
            for (int c1 = Math.min(r, n - 1); c1 >= 0; c1--) {
                for (int c2 = Math.max(c1, n - 1 - r); c2 < n; c2++) {
                    int max = 0;
                    for (int i = c1 - 1; i <= c1 + 1; i++) {
                        for (int j = c2 - 1; j <= c2 + 1; j++) {
                            if (i >= 0 && i < n && j >= 0 && j < n && i <= j)
                                max = Math.max(max, tmp[i][j]);
                        }
                    }
                    dp[c1][c2] = max + grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
                } 
            }
            int[][] temp = dp;
            dp = tmp;
            tmp = temp;
        }
        return tmp[0][n - 1];
    }
}