class Solution {
    private int len;
    
    public int smallestRangeII(int[] nums, int k) {
        len = nums.length;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++)
            result = Math.min(result, getResult(nums, k, i));
        return result;
    }
    
    private int getResult(int[] nums, int k, int i) {
        if (i == 0)
            return nums[len - 1] - nums[0];
        int max = Math.max(nums[i - 1] + k, nums[len - 1] - k);
        int min = Math.min(nums[0] + k, nums[i] - k);
        return max - min;
    }
} 