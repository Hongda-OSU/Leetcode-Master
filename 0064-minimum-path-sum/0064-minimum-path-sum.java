class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length - 1, n = grid[0].length - 1;
        int[][] memo = new int[m + 1][n + 1];
        return minSum(grid, m, n, memo);
    }
    
    public int minSum(int[][] grid, int m, int n, int[][] memo) {
        if (m == 0 && n == 0)
            return grid[m][n];
        // in case m - 1 or n - 1 < 0
        else if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        // don't need to re-find
        else if (memo[m][n] != 0)
            return memo[m][n];
        else 
           return memo[m][n] = grid[m][n] + Math.min(minSum(grid, m - 1, n, memo), minSum(grid, m, n - 1, memo));
    }
}