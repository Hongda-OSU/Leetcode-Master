class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int rows = matrix.length, cols = matrix[0].length, maxLength = 0;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int[] row : dp) 
            Arrays.fill(row, -1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, dp, i, j, Integer.MIN_VALUE));
            }
        }
        return maxLength;
    }
    
    public int dfs(int[][] matrix, int[][] dp, int row, int col, int compareWith) {
        int rows = matrix.length, cols = matrix[0].length, result = 0;
        boolean safe = isSafe(matrix, row, col, compareWith);
        if (safe) {
            if (dp[row][col] != -1)
                return dp[row][col];
            int temp = matrix[row][col];
            matrix[row][col] = -1;
            int d = dfs(matrix, dp, row + 1, col, temp);
            int u = dfs(matrix, dp, row - 1, col, temp);
            int r = dfs(matrix, dp, row, col + 1, temp);
            int l = dfs(matrix, dp, row, col - 1, temp);
            result = 1 + Math.max(Math.max(d, u), Math.max(r, l));
            matrix[row][col] = temp;
            dp[row][col] = result;
        }
        return result;
    }
    
    public boolean isSafe(int[][] matrix, int row, int col, int compareWith) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] > compareWith && compareWith != -1)
            return true;
        return false;
    }
}