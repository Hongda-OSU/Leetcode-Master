class Solution {
   public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int take = 0;
            dp[i] = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(n, i + 3); j++) {
                take += stoneValue[j];
                dp[i] = Math.max(dp[i], take - dp[j + 1]);
            }
        }
        int diff = dp[0]; // Alice goes first, starting from the first stone
        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }
}