class Solution {
   public static int minSteps(int n) {
    int[] dp = new int[n + 1];
		
    for (int k = 2; k <= n; k++) {
        dp[k] = Integer.MAX_VALUE;
				
        for (int i = 1; i < k; i++) {
            if (k % i != 0) continue;
            dp[k] = Math.min(dp[k], dp[i] + k / i);
        }
    }
        
    return dp[n];
}
}