class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }
    
    public int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = -1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] >= target) 
                right = pivot - 1;
            else
                left = pivot + 1;
            if (nums[pivot] == target)
                index = pivot;
        } 
        return index;
    }
    
    public int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = -1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] <= target) 
                left = pivot + 1;
            else
                right = pivot - 1;
            if (nums[pivot] == target)
                index = pivot;
        } 
        return index;
    }
}