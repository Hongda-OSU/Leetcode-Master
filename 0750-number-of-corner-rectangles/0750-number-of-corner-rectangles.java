class Solution {
    public int countCornerRectangles(int[][] grid) {
        //init array of column pairs, as per problem statement cols less than or equals to 200
        int[][] colPairs = new int[200][200];
        int cols = grid[0].length, res = 0;
        //for every row
        for (int[] row : grid) {
            //start loop on columns need to check every pair of columns in the row
            for (int c1= 0; c1 < cols - 1; c1++) {
                if (row[c1] == 1) {
                    for (int c2 = c1+1; c2 < cols; c2++) {
                        //if both row[c1] and row[c2] are 1 this is potentially a rectangle
                        if (row[c2] == 1) {
                            //get the previous value before incrementing number of rectangles will be minus 1 number of
                            //rows cause we need two rows to form first rectangle
                            res+=colPairs[c1][c2];
                            ++colPairs[c1][c2];
                        }
                    }
                }
            }
        }
        return res;
    }
}