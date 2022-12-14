class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0, right = 0;
        for (int num : nums) right += num;
        for (int i = 0; i < nums.length; i++) {
            if (left == right - left - nums[i]) return i;
            left += nums[i];
        }
        return -1;
    }
}