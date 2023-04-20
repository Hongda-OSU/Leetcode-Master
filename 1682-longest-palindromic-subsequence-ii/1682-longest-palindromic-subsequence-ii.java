class Solution {
    public int longestPalindromeSubseq(String s) {
         int n = s.length();
        int[][][] dp = new int[26][n][n];
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[s.charAt(i) - 'a'][i][i + 1] = 2;
            }
        }
        
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int c = 0; c < 26; c++) {
                    dp[c][i][j] = Math.max(dp[c][i + 1][j], dp[c][i][j - 1]);
                }
                
                if (s.charAt(i) == s.charAt(j)) {
                    int exclude = s.charAt(i) - 'a';
                    for (int c = 0; c < 26; c++) {
                        if (c == exclude) {
                            continue;
                        }
                        
                        dp[exclude][i][j] = Math.max(dp[exclude][i][j], 2 + dp[c][i + 1][j - 1]);
                    }
                }
            }
        }
        
        int max = 0;
        for (int c = 0; c < 26; c++) {
            max = Math.max(dp[c][0][n - 1], max);
        }
        return max;
    }
}