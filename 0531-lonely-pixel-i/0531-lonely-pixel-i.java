class Solution {
    public int findLonelyPixel(char[][] picture) {
        int[] row = new int[picture.length], col = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            int count = 0, index = -1;
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    count++;
                    index = j;
                    col[j]++;
                }
            }
            if (count == 1)
                row[i] = index + 1;
        }
        int result = 0;
        for (int r : row) {
            if (r > 0 && col[r - 1] == 1)
                result++;
        }
        return result;
    }
}