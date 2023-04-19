class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (isEqual(mat, target))
                return true;
            mat = rotate(mat);
        }
        return false;
    }
    
    private boolean isEqual(int[][] mat, int[][] target) {
        if (mat.length != target.length)
            return false;
        if (mat[0].length != target[0].length)
            return false;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
    
    private int[][] rotate(int[][] mat) {
        int[][] tmp = mat;
        int m = tmp.length;
        for (int col = 0; col < m; col++) {
            for (int row = col + 1; row < m; row++) {
                int val = tmp[row][col];
                tmp[row][col] = tmp[col][row];
                tmp[col][row] = val;
            }
        }
        for (int col1 = 0, col2 = m - 1; col1 < m / 2; col1++, col2--) {
            for (int row = 0; row < m; row++) {
                int val = tmp[row][col1];
                tmp[row][col1] = tmp[row][col2];
                tmp[row][col2] = val;
            }
        }
        return tmp;
    }
}