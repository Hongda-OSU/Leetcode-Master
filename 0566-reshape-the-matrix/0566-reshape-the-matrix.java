class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] result = new int[r][c];
        int rm = mat.length, cm = mat[0].length;
        if (rm == 0 || rm * cm != r * c) return mat;
        for (int i = 0; i < r * c; i++) {
            // i/c => which row, i%c => which column
            result[i/c][i%c] = mat[i/cm][i%cm];
        }
        return result;
    }
}