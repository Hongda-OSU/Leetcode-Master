class Solution {
    public int longestPalindromeSubseq(String s) {
	Integer[][][] dp = new Integer[s.length()][s.length()][27];
	return helper(dp, 0, s.length()-1, 26, s);
}

private int helper(Integer[][][] dp, int i, int j, int x, String s) {
	if (dp[i][j][x] != null) return dp[i][j][x];
	if (i >= j) return 0;
	dp[i][j][x] = Math.max(helper(dp, i+1, j, x, s), helper(dp, i, j-1, x, s));
	if (s.charAt(i) == s.charAt(j) && (s.charAt(i) - 'a') != x) {
		dp[i][j][x] = Math.max(dp[i][j][x], 2 + helper(dp, i+1, j-1, s.charAt(i) - 'a', s));
	}
	return dp[i][j][x];
}
}