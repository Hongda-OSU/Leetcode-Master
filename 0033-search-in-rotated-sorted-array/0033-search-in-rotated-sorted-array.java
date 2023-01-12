class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                // the left half is monotonic, yet still does not satisfy
                if (nums[left] <= nums[pivot] && nums[left] > target) {
                    left = pivot + 1;
                } else {
                    right = pivot - 1;
                }
            } else {
                // the right half is monotonic, yet still does not satisfy
                if (nums[right] >= nums[pivot] && nums[right] < target) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        return -1;
    }
}