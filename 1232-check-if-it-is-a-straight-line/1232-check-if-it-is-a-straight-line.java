class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            // Collinearity of Three Points: (y2 – y1)/(x2 – x1) = (y3 – y2)/(x3 – x2)
            int x1 = coordinates[i - 2][0],
                x2 = coordinates[i - 1][0],
                x3 = coordinates[i][0],
                y1 = coordinates[i - 2][1], 
                y2 = coordinates[i - 1][1], 
                y3 = coordinates[i][1];
            if ((y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1))
                return false;
        }
        return true;
    }
}