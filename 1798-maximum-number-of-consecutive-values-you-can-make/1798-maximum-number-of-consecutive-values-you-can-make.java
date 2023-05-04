class Solution {
   public int getMaximumConsecutive(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = 1;
        for(int i = 0 ; i < len ; i++) {
            if(nums[i] > ans) break;
            ans += nums[i];
        }
        return ans;
    }
}