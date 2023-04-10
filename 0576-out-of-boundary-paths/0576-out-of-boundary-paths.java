class Solution {
    private Integer[][][] memo;
    private int rows, cols;
    private int[] dirs = new int[]{0, 1, 0, -1, 0};
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new Integer[m][n][maxMove + 1];
        rows = m; cols = n;
        return findPathsHelper(startRow, startColumn, maxMove);
    }
    
    public int findPathsHelper(int row, int col, int maxMove) {
        if (row < 0 || row == rows || col < 0 || col == cols)
            return 1;
        if (memo[row][col][maxMove] != null)
            return memo[row][col][maxMove];
        if (maxMove == 0)
            return 0;
        int result = 0;
        for (int i = 0; i < 4; i++)
            result = (result + findPathsHelper(row + dirs[i], col + dirs[i + 1], maxMove - 1)) % 1_000_000_007;
        return memo[row][col][maxMove] = result;
    }
}