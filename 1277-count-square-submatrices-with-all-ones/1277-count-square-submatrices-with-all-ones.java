class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0,j=0;
       
        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                if(matrix[i][j]!=0)
                {
                    matrix[i][j]=1+Math.min(Math.min(matrix[i-1][j],matrix[i][j-1]),matrix[i-1][j-1]);;
                }
               
            }
        }
        int sum=0;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                sum+=matrix[i][j];
            }
        }
        return sum;
    }
}