class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, column = matrix[0].length;
        int left = 0, right = row * column - 1, pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            int value = matrix[pivot / column][pivot % column];
            if (value == target) return true;
            else if (value < target) left = pivot + 1;
            else right = pivot - 1;
        }
        return false;
    }
}