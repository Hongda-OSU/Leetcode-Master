class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        int robFirst = rob(nums, 0, nums.length - 2);
        int robSecond = rob(nums, 1, nums.length - 1);
        return Math.max(robFirst, robSecond);
    }
    
    public int rob(int[] nums, int start, int end) {
        int robber1Val = 0, robber2Val = 0;
        for (int i = start; i <= end; i++) {
            int temp = robber1Val;
            int curr = nums[i];
            robber1Val = Math.max(curr + robber2Val, robber1Val);
            robber2Val = temp;
        }
        return robber1Val;
    }
}