class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int maxArea = 0, rows = grid.length, columns = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid[r][c] == 1)
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
            }
        }
        return maxArea;
    }
    
    public int dfs(int[][] grid, int r, int c) {
        int rows = grid.length, columns = grid[0].length;
        if (r >= 0 && c >= 0 && r < rows && c < columns && grid[r][c] == 1) {
            grid[r][c] = 0;
            return 1 + dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
        }
        return 0;
    }
}