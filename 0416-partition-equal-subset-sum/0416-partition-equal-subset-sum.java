class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (sum % 2 != 0) return false;
        int subSetSum = sum / 2, len = nums.length;
        boolean[][] dp = new boolean[len + 1][subSetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subSetSum; j++) {
                if (j < curr)
                    dp[i][j] = dp[i - 1][j];
                else 
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curr];
            }
        }
        return dp[len][subSetSum];
    } 
}