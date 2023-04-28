class Solution {
    public int maxCoins(int[] nums) {
        // add 1 before and after nums
        int n = nums.length + 2;
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n - 2);
        newNums[0] = 1;
        newNums[n - 1] = 1;

        // cache the results of dp
        int[][] memo = new int[n][n];

        // we can not burst the first one and the last one
        // since they are both fake balloons added by ourselves
        return dp(memo, newNums, 1, n - 2);
    }

    public int dp(int[][] memo, int[] nums, int left, int right) {
        // return maximum if we burst all nums[left]...nums[right], inclusive
        if (right - left < 0) {
            return 0;
        }

        // we've already seen this, return from cache
        if (memo[left][right] > 0) {
            return memo[left][right];
        }

        // find the last burst one in nums[left]...nums[right]
        int result = 0;
        for (int i = left; i <= right; i++) {
            // nums[i] is the last burst one
            int gain = nums[left - 1] * nums[i] * nums[right + 1];
            // nums[i] is fixed, recursively call left side and right side
            int remaining = dp(memo, nums, left, i - 1) + dp(memo, nums, i + 1, right);
            result = Math.max(result, remaining + gain);
        }
        // add to the cache
        memo[left][right] = result;
        return result;
    }
}