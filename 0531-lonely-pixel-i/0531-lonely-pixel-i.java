class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < picture.length; i++) {
            int count = 0, index = -1;
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    count++;
                    index = j;
                    col[j]++;
                }
            }
            // only one black this row
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