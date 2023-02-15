class Solution {
    private int island;
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int r = 0; r < grid1.length; r++) {
            for (int c = 0; c < grid1[0].length; c++) {
                if (grid2[r][c] == 1) {
                    island = 1;
                    dfs(grid1, grid2, r, c);
                    count += island;
                }
            }
        }
        return count;
    }
    
    public void dfs(int[][] grid1, int[][] grid2, int row, int col) {
        if (row < 0 || row >= grid1.length || col < 0 || col >= grid1[0].length || grid2[row][col] == 0)
            return;
        grid2[row][col] = 0;
        if (grid1[row][col] == 0)
            island = 0;
        dfs(grid1, grid2, row - 1, col);
        dfs(grid1, grid2, row + 1, col);
        dfs(grid1, grid2, row, col - 1);
        dfs(grid1, grid2, row, col + 1);
    }
}