class Solution {
    public int maximalSquare(char[][] matrix) {
        int r=matrix.length;
        if(r==0) return 0;
        int c=matrix[0].length,edge=0;
        int[][] dp=new int[r+1][c+1];
        for(int i=1;i<=r;i++)
            for(int j=1;j<=c;j++) {
                if(matrix[i-1][j-1]=='0') continue;
                dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                edge=Math.max(edge,dp[i][j]);
            }
        return edge*edge;
    }
}