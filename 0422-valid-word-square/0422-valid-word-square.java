class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        int[][] mat = new int[n][n];
        
        for (int i=0;i<n;i++){
            char[] ch = words.get(i).toCharArray();
            //individual string should not be greater than that of the words length
            if (ch.length > n) return false;
            //assign character to the matrix
            for(int j=0;j<ch.length;j++)
                mat[i][j] = ch[j];
        }
        
        //check if each characters are same
        for (int i=0;i<n;i++)
            for (int j=i;j<n;j++)
                if(mat[i][j] != mat[j][i]) return false;
        return true;
    }
}