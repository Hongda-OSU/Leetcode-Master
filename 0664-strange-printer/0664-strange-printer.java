class Solution {
    public int strangePrinter(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = 0; j < dp.length; j++) {
                if (i > j) 
                    continue;
                else if (i == j)
                    dp[i][j] = 1;
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++)
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    if (s.charAt(i) == s.charAt(j))
                        min--;
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}