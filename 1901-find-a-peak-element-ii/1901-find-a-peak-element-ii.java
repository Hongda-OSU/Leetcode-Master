class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol = 0, endCol = mat[0].length - 1;
        while (startCol <= endCol) {
            int maxRow = 0, midCol = (startCol + endCol) >>> 1;
            for (int row = 0; row < mat.length; row++)
                maxRow = mat[row][midCol] >= mat[maxRow][midCol] ? row : maxRow;
            boolean leftBigger = midCol - 1 >= startCol && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean rightBigger = midCol + 1 <= endCol && mat[maxRow][midCol + 1] > mat[maxRow][midCol];
            if (!leftBigger && !rightBigger)
                return new int[]{maxRow, midCol};
            else if (rightBigger)
                startCol = midCol + 1;
            else
                endCol = midCol - 1;
        }
        return null;
    } 
}