class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0, top = 0, right = n - 1, down = n - 1;
        int val = 1;
        while (left <= right) {
            for (int j = left; j <= right; j++) 
                result[top][j] = val++;
            top++;
            for (int i = top; i <= down; i++) 
                result[i][right] = val++;
            right--;
            for (int j = right; j >= left; j--) 
                result[down][j] = val++;
            down--;
            for (int i = down; i >= top; i--)
                result[i][left] = val++;
            left++;            
        }
        return result;
    }
}