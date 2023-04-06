class Solution {
    public int longestLine(int[][] M) {
        if (M.length==0) return 0;
        int m=M.length, n=M[0].length, res=0;
        int[][][] dp= new int[m+1][n+2][4];
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (M[i][j]==1){
                    res=Math.max(res, dp[i+1][j+1][0]=dp[i][j+1][0]+1);//update row
                    res=Math.max(res, dp[i+1][j+1][1]=dp[i+1][j][1]+1);//update column
                    res=Math.max(res, dp[i+1][j+1][2]=dp[i]  [j][2]+1);//update diagnoal
                    res=Math.max(res, dp[i+1][j+1][3]=dp[i][j+2][3]+1);//update antidiagonal
                }
        return res;
    }
}