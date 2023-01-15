class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums.length == 1) return 0;
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] > nums[pivot + 1])
                right = pivot;
            else 
                left = pivot + 1;
        }
        return left;
    }
}