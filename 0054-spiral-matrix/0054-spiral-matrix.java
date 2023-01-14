class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        int up = 0, left = 0, down = rows - 1, right = columns - 1;
        List<Integer> result = new ArrayList<>();
        while (result.size() < rows * columns) {
            for (int column = left; column <= right; column++) {
                result.add(matrix[up][column]);
            }
            for (int row = up + 1; row <= down; row++) {
                result.add(matrix[row][right]);
            } 
            if (up != down) {
                for (int column = right - 1; column >= left; column--) {
                    result.add(matrix[down][column]);
                }
            }
            if (left != right) {
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            up++;
            left++;
            down--;
            right--;
        }
        return result;
    }
}