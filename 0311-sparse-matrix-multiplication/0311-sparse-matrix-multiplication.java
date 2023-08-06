class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, n = mat1[0].length, n2 = mat2[0].length;
        int[][] result = new int[m][n2];
        
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (mat1[i][k] != 0) {
                    for (int j = 0; j < n2; j++) {
                        if (mat2[k][j] != 0)
                            result[i][j] += mat1[i][k] * mat2[k][j];
                    }
                }
            }
        }
        return result;
    }
}