class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int start = 0, end = mat[0].length - 1;
        while (start <= end) {
            int max = 0, pivot = (start + end) >>> 1;
            for (int row = 0; row < mat.length; row++)
                max = mat[row][pivot] >= mat[max][pivot] ? row : max;
            boolean leftIsBig = pivot - 1 >= start && mat[max][pivot - 1] > mat[max][pivot];
            boolean rightIsBig = pivot + 1 <= end && mat[max][pivot + 1] > mat[max][pivot];
            if (!leftIsBig && !rightIsBig)
                return new int[]{max, pivot};
            else if (rightIsBig)
                start = pivot + 1;
            else 
                end = pivot - 1;
        }
        return null;
    }
}