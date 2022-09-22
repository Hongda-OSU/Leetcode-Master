class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[0] < nums[right] || nums.length == 1) return nums[0];
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return nums[pivot + 1];
            }
            if (nums[pivot - 1] > nums[pivot]) {
                return nums[pivot];
            }
            if (nums[pivot] > nums[0]) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }
}