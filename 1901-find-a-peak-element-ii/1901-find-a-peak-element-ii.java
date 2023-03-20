class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startRow = 0;
        int endRow = mat.length -1;
        while(startRow <= endRow) {
            int midRow = startRow  + (endRow - startRow)/2;
            int maxElementInmidRow = findMaxElementPosition(mat[midRow] , mat[midRow].length);
            if(midRow == 0) {
                if(mat[midRow][maxElementInmidRow] > mat[midRow +1][maxElementInmidRow]) {
                    return new int[]{midRow,maxElementInmidRow};
                }
            }
            if(midRow == mat.length-1) {
                if(mat[midRow][maxElementInmidRow] > mat[midRow -1][maxElementInmidRow]) {
                    return new int[]{midRow,maxElementInmidRow};
                }
            }
            else if(midRow >0  && midRow < mat.length ) {
                if(mat[midRow][maxElementInmidRow] > mat[midRow +1][maxElementInmidRow] && mat[midRow][maxElementInmidRow] > mat[midRow -1][maxElementInmidRow] )
                    return new int[]{midRow,maxElementInmidRow};
                
            }
            if(mat[midRow][maxElementInmidRow] < mat[midRow+1][maxElementInmidRow]) {
                startRow = midRow+1;
            }
            else
                endRow = midRow -1;
        }
        return new int[]{-1,-1};
    }
    
    public int findMaxElementPosition(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int indx =0;
        for(int i = 0;i<n;i++) {
            if(arr[i] > max) {
                max = arr[i];
                indx =i;
            }
        }
        return indx;
    }
}