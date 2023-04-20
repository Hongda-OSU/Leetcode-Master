class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        char[][] dpChar = new char[n][n];
        char[] arr = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    dpChar[i][j] = arr[i];
                    if (arr[i] == dpChar[i + 1][j - 1])
                        dp[i][j] = dp[i + 1][j - 1];
                    else 
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    if (dp[i + 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i + 1][j];
                        dpChar[i][j] = dpChar[i + 1][j];
                    } else if (dp[i + 1][j] < dp[i][j - 1] || dpChar[i + 1][j] == dpChar[i][j - 1]) {
                        dp[i][j] = dp[i][j - 1];
                        dpChar[i][j] = dpChar[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                        dpChar[i][j] = 'a' - 1;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}