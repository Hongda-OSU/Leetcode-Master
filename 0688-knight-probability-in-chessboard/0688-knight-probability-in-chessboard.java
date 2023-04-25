class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        for (double[][] i : dp) {
            for (double[] j : i) 
                Arrays.fill(j, -1);
        }
        return helper(n, k, row, column, dp);
    }
    
    private double helper(int n, int k, int row, int column, double[][][] dp) {
        if (row < 0 || column < 0 || row >= n || column >= n)
            return 0;
        if (k == 0)
            return 1;
        if (dp[row][column][k] != -1)
            return dp[row][column][k];
        double prob = 0;
        prob += helper(n, k - 1, row - 2, column + 1, dp) / 8.0;
        prob += helper(n, k - 1, row - 2, column - 1, dp) / 8.0;
        prob += helper(n, k - 1, row + 2, column - 1, dp) / 8.0;
        prob += helper(n, k - 1, row + 2, column + 1, dp) / 8.0;
        prob += helper(n, k - 1, row - 1, column + 2, dp) / 8.0;
        prob += helper(n, k - 1, row - 1, column - 2,  dp) / 8.0;
        prob += helper(n, k - 1, row + 1, column - 2,  dp) / 8.0;
        prob += helper(n, k - 1, row + 1, column + 2,  dp) / 8.0;
        return dp[row][column][k] = prob;
    }
}