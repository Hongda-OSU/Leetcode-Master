class Solution {
    public int countCornerRectangles(int[][] grid) {
        int[][] colPair = new int[200][200];
        int cols = grid[0].length, result = 0;
        for (int[] row : grid) {
            for (int col1 = 0; col1 < cols - 1; col1++) {
                if (row[col1] == 1) {
                    for (int col2 = col1 + 1; col2 < cols; col2++) {
                        if (row[col2] == 1) {
                            result += colPair[col1][col2];
                            colPair[col1][col2] += 1;
                        }
                    }
                }
            }
        }
        return result;
    }
}