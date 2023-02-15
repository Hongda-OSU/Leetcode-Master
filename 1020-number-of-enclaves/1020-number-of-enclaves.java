class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // DFS triggered once grid[i][j] == 1 && it is a non-fully closed islands
                if (grid[r][c] == 1 && (r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1))
                    dfs(grid, r, c);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
    
    public void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return;
        grid[row][col] = 0;
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}