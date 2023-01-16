class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int row = 0, column = matrix[0].length - 1;
        while (column >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][column]) 
                return true;
            else if (target < matrix[row][column]) 
                column--;
            else 
                row++;
        }
        return false;
    }
}