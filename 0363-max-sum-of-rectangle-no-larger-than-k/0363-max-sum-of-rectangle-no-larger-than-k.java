class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < m; r1++) {
            int[] arr = new int[n];
            for (int r2 = r1; r2 < m; r2++) {
                for (int c = 0; c < n; c++) 
                    arr[c] += matrix[r2][c];
                result = Math.max(result, maxSumSubArray(arr, n, k));
            }
        }
        return result;
    }
    
    public int maxSumSubArray(int[] arr, int n, int k) {
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(0);
        int result = Integer.MIN_VALUE;
        for (int i = 0, right = 0; i < n; i++) {
            right += arr[i];
            Integer left = bst.ceiling(right - k);
            if (left != null)
                result = Math.max(result, right - left);
            bst.add(right);
        }
        return result;
    }
}