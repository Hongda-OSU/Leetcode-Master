class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length, max = 1;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    
    public int dfs(int[][] matrix, int row, int col, int rows, int cols, int[][] cache) {
        if (cache[row][col] != 0)
            return cache[row][col];
        int max = 1;
        for (int[] dir : dirs) {
            int x = row + dir[0], y = col + dir[1];
            if (x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] <= matrix[row][col])
                continue;
            int len = 1 + dfs(matrix, x, y, rows, cols, cache);
            max = Math.max(max, len);
        }
        cache[row][col] = max;
        return max;
    } 
}