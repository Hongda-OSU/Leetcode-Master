class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = (left + right) >>> 1;
            if (nums[pivot] == target)
                return true;
            if (nums[pivot] < nums[right] || nums[pivot] < nums[left]) {
                if (target > nums[pivot] && target <= nums[right])
                    left = pivot + 1;
                else 
                    right = pivot - 1;
            } else if (nums[pivot] > nums[right] || nums[pivot] > nums[left]) {
                if (target < nums[pivot] && target >= nums[left])
                    right = pivot - 1;
                else 
                    left = pivot + 1;
            } else {
                right--;
            }
        }
        return false;
    }
}