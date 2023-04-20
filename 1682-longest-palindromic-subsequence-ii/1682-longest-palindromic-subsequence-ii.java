class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length(), base = 251; //set base 251 because max length of s is 250.
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--){
            for (int j = i + 1; j <= n; j++){
                int prev = dp[i + 1][j - 1] / base;
                if (s.charAt(i - 1) == s.charAt(j - 1) && s.charAt(j - 1) != prev){
                    dp[i][j] = dp[i + 1][j - 1] % base + 2 + s.charAt(j - 1) * base; 
					//store prev info with *251, so that it won't interfere with our acutal answer.
                }
                else{
                    if (dp[i + 1][j] % base > dp[i][j - 1] % base){ //check the score with %251
                        dp[i][j] = dp[i + 1][j];
                    }else{
                        dp[i][j] = dp[i][j - 1];
                    }
                } 
            }
        }

        return dp[1][n] % base; //remember to %251 here
    }
}