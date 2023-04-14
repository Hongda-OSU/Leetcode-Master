class Solution {
    public int findTargetSumWays(int[] nums, int S) {
    int sum = 0;
    S = Math.abs(S);
    for(int i = 0; i < nums.length; i++)
        sum += nums[i];
	// Invalid S, just return 0
    if( S > sum || (sum + S) % 2 != 0 )
        return 0;

    int dp[][] = new int[(sum + S) / 2 + 1][nums.length + 1];
    dp[0][0] = 1;
    for(int i = 0; i < nums.length; i++) { // empty knapsack must be processed specially
        if( nums[i] == 0 )
            dp[0][i + 1] = dp[0][i] * 2;
        else
            dp[0][i + 1] = dp[0][i];
    }
    for(int i = 1; i < dp.length; i++) {
        for(int j = 0; j < nums.length; j++) {
            dp[i][j + 1] += dp[i][j];
            if( nums[j] <= i )
                dp[i][j + 1] += dp[i - nums[j]][j];
        }
    }
    return dp[(sum + S) / 2][nums.length];
}
}