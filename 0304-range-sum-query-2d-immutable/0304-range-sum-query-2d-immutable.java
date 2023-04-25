class NumMatrix {
    int preSum[][];
public NumMatrix(int[][] matrix) {

	// important to get minimum time. . .
	//without matrix[0] condtns. . faster than 78%. with it, faster than 99.97%
	
    if(matrix ==null || matrix.length==0 || matrix[0] == null || matrix[0].length==0)
        preSum = new int[1][1];
    else
    {
        int n = matrix.length, m=matrix[0].length;
        preSum = new int[n+1][m+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                preSum[i+1][j+1] = matrix[i][j] + preSum[i+1][j] + preSum[i][j+1] - preSum[i][j];
											//= left + (top- diagnal)
			}
			// at each index you save the sum of rectange with i, j as the bottom right and 0,0 as the top right.
			
    }
	
}

public int sumRegion(int row1, int col1, int row2, int col2) {
    if(preSum.length==1 || preSum[0].length==1)
        return 0;
    
    return preSum[row2+1][col2+1] - preSum[row2+1][col1] + preSum[row1][col1] - preSum[row1][col2+1];
			 
}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */