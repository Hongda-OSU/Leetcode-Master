class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            int topRight = 0;
            for (int j = i - 1; j >= 0; j--) {
                int temp = dp[j];
                dp[j] = arr[i] == arr[j] ? 2 + topRight : Math.max(dp[j], dp[j + 1]);
                topRight = temp;
            }
        }
        return dp[0];
    }
}