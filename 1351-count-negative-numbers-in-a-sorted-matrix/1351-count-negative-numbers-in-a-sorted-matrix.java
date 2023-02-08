class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;
        for (int i = 0 ; i < grid.length; i++) {
            result += negativeRowI(grid[i]);
        }
        return result;
    }
    
    public int negativeRowI(int[] row) {
        int left = 0, right = row.length - 1, count = 0;
        while (left <= right) {
            int pivot = (left + right) >>> 1;
            if (row[pivot] >= 0) {
                left = pivot + 1;
            } else if (row[pivot] < 0) {
                count += right - pivot + 1;
                right = pivot - 1;
            }
        }
        return count;
    } 
}