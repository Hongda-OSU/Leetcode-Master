class Solution {
    public int n;
    
    public int swimInWater(int[][] grid) {
        n = grid.length;
        int left = grid[0][0], right = n * n - 1;
        while (left < right) {
            int pivot = (left + right) >>> 1;
            if (dfs(grid, 0, 0, pivot, new boolean[n][n]))
                right = pivot;
            else
                left = pivot + 1;
        }
        return left;
    }
    
    public boolean dfs(int[][] grid, int i, int j, int pivot, boolean[][] visited) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] > pivot)
            return false;
        visited[i][j] = true;
        if (i == n - 1 && j == n - 1)
            return true;
        return dfs(grid, i - 1, j, pivot, visited) ||
            dfs(grid, i + 1, j, pivot, visited) ||
            dfs(grid, i, j - 1, pivot, visited) ||
            dfs(grid, i, j + 1, pivot, visited);
    }
}