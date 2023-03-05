class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int mid = nums.length / 2;
        int ele = nums[mid];
        if (ele != target)
            return false;
        int count = 0;
        for (int i = mid; i >= 0; i--) {
            if (nums[i] != ele)
                break;
            count++;
        }
        for (int i = mid + 1; i < nums.length; i++) {
            if (nums[i] != ele)
                break;
            count++;
        } 
        return count > nums.length / 2;
    }
}