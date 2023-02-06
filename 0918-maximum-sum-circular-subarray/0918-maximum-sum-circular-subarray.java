class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0], minSum = nums[0], currMax = 0, currMin = 0, sum = 0;
        for (int num : nums) {
            currMax = Math.max(currMax + num, num);
            currMin = Math.min(currMin + num, num);
            maxSum = Math.max(maxSum, currMax);
            minSum = Math.min(minSum, currMin);
            sum += num;
        }
        return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
    }
}