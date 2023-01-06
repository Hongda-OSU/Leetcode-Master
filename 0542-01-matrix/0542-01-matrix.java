class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, column = mat[0].length, max = row + column;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (mat[r][c] == 0) continue;
                int top = max, left = max;
                if (r - 1 >= 0) top = mat[r-1][c];
                if (c - 1 >= 0) left = mat[r][c-1];
                mat[r][c] = Math.min(top, left) + 1;
            }
        }
        for (int r = row - 1; r >= 0; r--) {
            for (int c = column - 1; c >= 0; c--) {
                if (mat[r][c] == 0) continue;
                int down = max, right = max;
                if (r + 1 < row) down = mat[r+1][c];
                if (c + 1 < column) right = mat[r][c+1];
                mat[r][c] = Math.min(mat[r][c], Math.min(down, right) + 1);
            }
        }
        return mat;
    }
}