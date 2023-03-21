class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int left = matrix[0][0], right = matrix[m - 1][n - 1], result = -1;
        while (left <= right) {
            int pivot = (left + right) >> 1;
            if (countLessOrEquel(matrix, pivot, m, n) >= k) {
                result = pivot;
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return result;
    }
    
    public int countLessOrEquel(int[][] matrix, int pivot, int m, int n) {
        int count = 0, c = n - 1;
        for (int r = 0; r < m; r++) {
            while (c >= 0 && matrix[r][c] > pivot)
                c--;
            count += (c + 1);
        }
        return count;
    }
}