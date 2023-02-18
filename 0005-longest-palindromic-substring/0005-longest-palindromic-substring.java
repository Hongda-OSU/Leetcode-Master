class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int left = 0, right = 0, len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                boolean startEqEnd = s.charAt(i) == s.charAt(j);
                if (i == j) 
                    //If the same char: 'a' is palindrome
                    dp[i][j] = true;
                else if (i - j == 1)
                    //If length 2: 'ab' is palindrome when 'a' == 'b'
                    dp[i][j] = startEqEnd;
                else if (startEqEnd && dp[i - 1][j + 1]) 
                    //Otherwise: string is palindrome if s(i) == s(j) and substring s(j + 1, i - 1) is palindrome
                    dp[i][j] = true;
                
                if (dp[i][j] && i - j > right - left) {
                    right = i;
                    left = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}