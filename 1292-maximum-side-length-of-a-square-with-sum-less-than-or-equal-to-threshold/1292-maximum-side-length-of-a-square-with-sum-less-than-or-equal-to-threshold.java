class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int row = mat.length, col = mat[0].length;
        // First, calculate the prefix sum matrix
        int[][] prefixSum = new int[row + 1][col + 1];
        // add padding so that edge cases are dealt with more smoothly.
        // we keep the prefixSum of mat[0][0] at prefixSum[1][1] and so on
        
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                prefixSum[r][c] = mat[r - 1][c - 1] - prefixSum[r - 1][c - 1] 
                    + prefixSum[r - 1][c] + prefixSum[r][c- 1];
            }
        }
        
        int low = 0, high = Math.min(row, col) - 1;
        while (low <= high) {
            int pivot = (low + high) >>> 1;
            // r and c of prefix sum matrix
            int minSumSubMat = Integer.MAX_VALUE;
            // With the current size, find the smallest sum starting from different places in the matrix
            for (int r = 1; r + pivot <= row; r++) {
                for (int c = 1; c + pivot <= col; c++) {
                    int sumSubMat = prefixSum[r + pivot][c + pivot] + prefixSum[r - 1][c - 1] 
                        - prefixSum[r + pivot][c - 1] - prefixSum[r - 1][c + pivot];
                    // the added part is subtracted twice
                    minSumSubMat = Math.min(minSumSubMat, sumSubMat);
                }
            }
            if (minSumSubMat <= threshold)
                low = pivot + 1;
            else
                high = pivot - 1;
        }
        return low;
    }
}