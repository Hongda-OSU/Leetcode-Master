class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        int[][] mat = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            char[] arr = words.get(i).toCharArray();
            if (arr.length > n)
                return false;
            for (int j = 0; j < arr.length; j++)
                mat[i][j] = arr[j];
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] != mat[j][i])
                    return false;
            }
        }
        return true;
    }
}