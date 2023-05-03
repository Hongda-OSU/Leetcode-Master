class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) 
            sum += num;
        if (sum % k != 0 || nums.length < k)
            return false;
        Arrays.sort(nums);
        return helper(nums, sum / k, nums.length - 1, new int[k]);
    }
    
    private boolean helper(int[] nums, int target, int i, int[] bucket) {
        if (i == -1)
            return true;
        for (int j = 0; j < bucket.length; j++) {
            if (bucket[j] + nums[i] <= target) {
                bucket[j] += nums[i];
                if (helper(nums, target, i - 1, bucket))
                    return true;
                bucket[j] -= nums[i];
            }
            if (bucket[j] == 0)
                break;
        }
        return false;
    }
}