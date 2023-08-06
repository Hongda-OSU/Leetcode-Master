class Solution {
    public int findLonelyPixel(char[][] picture) {

        //track the only one 'B''s column
        int[] row = new int[picture.length];
        //count the number of 'B' in column
        int[] column = new int[picture[0].length];

        //Time: O(M * N)
        for (int i = 0; i < picture.length; i++) {
            int c = 0; int x = -1;
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    c++; x = j; column[j]++;
                }
            }
            //if there is only one 'B' in the row, then we track it's column
            if (c == 1) row[i] = x + 1;
        }

        //Time: O(M)
        int res = 0;
        for (int r: row)
            if (r > 0  && column[r - 1] == 1) res++;
        return res;
    }
}