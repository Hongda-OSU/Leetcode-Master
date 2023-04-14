class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (target > sum || target < -sum)
            return 0;
        int[] dp = new int[2 * sum + 1];
        dp[0 + sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[2 * sum + 1];
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (dp[j] != 0) {
                    next[j + nums[i]] += dp[j];
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[sum + target];
    }
}