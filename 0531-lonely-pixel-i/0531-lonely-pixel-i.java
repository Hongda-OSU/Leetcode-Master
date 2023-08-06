public class Solution {
    public int findLonelyPixel(char[][] pic) {
        int m = pic.length;
        int n = pic[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += pic[i][j] == 'B' ? 1 : 0;
                cols[j] += pic[i][j] == 'B' ? 1 : 0;
            }
        }

        int lonely = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n && rows[i] > 0; j++) {
                lonely += (pic[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) ? 1 : 0;
            }
        }

        return lonely;     
    }
}