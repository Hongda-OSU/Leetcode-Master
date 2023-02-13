class Solution {
    public int minFallingPathSum(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            // finding answers for each column of first row seperatly and storing the minimum value in variable ans 
            result = Math.min(result, helper(matrix, dp, 0, i));
        }
        return result;
    }
    
    // helper function which computes the result for each column in row 1
    public int helper(int[][] matrix, Integer[][] dp, int i, int j) {
        int n = matrix.length;
        if (j >= n || j < 0) // base-case 1
            return (int)Math.pow(10, 7);
        if (i == n - 1)
            return matrix[i][j]; // base-case 2
        if (dp[i][j] != null)
            return dp[i][j]; // avoiding repetitive steps by returning previously calculated ans
        int x = matrix[i][j] + helper(matrix, dp, i + 1, j);
        int y = matrix[i][j] + helper(matrix, dp, i + 1, j + 1);
        int z = matrix[i][j] + helper(matrix, dp, i + 1, j - 1);
        int result = Math.min(x, Math.min(y, z));
        dp[i][j] = result;
        return result;
    } 
}