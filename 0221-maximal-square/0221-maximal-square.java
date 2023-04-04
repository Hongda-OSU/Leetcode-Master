class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix.length == 0) return 0;
        
        int[][] memo = new int[matrix.length][matrix[0].length];
        int max = 0;
        int currMax = 0;
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                currMax = findsquare(matrix,i,j,memo);
                if(max < currMax)
                    max = currMax;
            }
        }
        return max*max;
    }
    
    private int findsquare(char[][] matrix, int i, int j, int[][] dp){
        
        if(i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0')
            return 0;
        if(dp[i][j] != 0) return dp[i][j];
        
        return dp[i][j]  =  1 + Math.min(findsquare(matrix, i+1, j+1,dp),
                                Math.min(findsquare(matrix, i+1,j,dp),
                                         findsquare(matrix, i, j+1, dp)));
    }
}