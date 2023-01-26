class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int dp[] = new int[nums.length];
        int result = 0;
        for (int i = 2; i < dp.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                result += dp[i];
            }
        }
        return result;
    }
}