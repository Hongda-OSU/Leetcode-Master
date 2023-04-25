class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][n];
        int res = 0;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] != 1) continue;
                for(int k = j+1;k < n;k++) {
                    if(grid[i][k] == 1) {
                        res += dp[j][k];
                        dp[j][k]++;
                    }
                }
            }
        }
        return res;
    }
}