class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];
        for(double[][] dprow: dp) {
            for (double[] newRow : dprow) {
                Arrays.fill(newRow, -1);
            }
        }
        return util (n,row,column,k,dp);
    }

    public double util(int n, int row, int col, int k,double[][][] dp) {
        //basecases 
        if(row < 0 || col < 0 || row >=n || col >=n ) {
            return 0;
        }

        if(k == 0) {
            return 1;
        }

        if(dp[row][col][k] != -1) {
            return dp[row][col][k];
        }

        double prob = 0;

        prob += util(n,row-2,col+1,k-1,dp)/8.0;
        prob += util(n,row-2,col-1,k-1,dp)/8.0;
        prob += util(n,row+2,col-1,k-1,dp)/8.0;
        prob += util(n,row+2,col+1,k-1,dp)/8.0;
        prob += util(n,row+1,col+2,k-1,dp)/8.0;
        prob += util(n,row-1,col+2,k-1,dp)/8.0;
        prob += util(n,row-1,col-2,k-1,dp)/8.0;
        prob += util(n,row+1,col-2,k-1,dp)/8.0;

        return dp[row][col][k] = prob;
    }
}