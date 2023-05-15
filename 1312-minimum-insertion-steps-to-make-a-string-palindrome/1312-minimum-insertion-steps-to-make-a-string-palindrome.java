class Solution {
    public int minInsertions(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int lcs = longestCommonSubsequence(s.toCharArray(), reverse.toCharArray());
        return s.length() - lcs;
    }
    
    private int longestCommonSubsequence(char[] arr1, char[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (arr1[i - 1] == arr2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n1][n2];
    }
} 