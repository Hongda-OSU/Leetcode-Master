class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] < nums[pivot + 1]) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }
        return left;
    }
}