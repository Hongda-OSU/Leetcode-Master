class Solution {
    public int smallestCommonElement(int[][] mat) {
         int n = mat.length, m = mat[0].length;
        for (int i = 0; i < m; i++) {
            boolean found = true;
            for (int j = 1; j < n && found; j++) 
                found = Arrays.binarySearch(mat[j], mat[0][i]) >= 0;
            if (found)
                return mat[0][i];
        }
        return -1;
    }
}