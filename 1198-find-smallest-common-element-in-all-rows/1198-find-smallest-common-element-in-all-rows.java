class Solution {
    public int smallestCommonElement(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] indexes = new int[row];
        int i = 0;
        while (i < row - 1 && indexes[i] < col && indexes[i + 1] < col) {
            int curr = mat[i][indexes[i]], next = mat[i + 1][indexes[i + 1]];
            if (curr == next)
                i++;
            else if (curr > next) 
                indexes[i + 1]++;
            else {
                for (int j = i; j >= 0; j--)
                    indexes[j]++;
                i = 0;
            }
        }
        return i == row - 1 && indexes[i] < col ? mat[i][indexes[i]] : -1;
    }
}