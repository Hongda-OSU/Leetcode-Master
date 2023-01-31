class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1, index = nums.length - k;
        while (left < right) {
            int pivot = partion(nums, left, right);
            if (pivot < index) left = pivot + 1;
            else if (pivot > index) right = pivot - 1;
            else return nums[pivot];
        }
        return nums[left];
    }
    
    public int partion(int[] nums, int left, int right) {
        int pivot = left, temp = Integer.MAX_VALUE;
        while (left <= right) {
            while (left <= right && nums[left] <= nums[pivot]) left++;
            while (left <= right && nums[right] > nums[pivot]) right--;
            if (left > right) break;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        temp = nums[right];
        nums[right] = nums[pivot];
        nums[pivot] = temp;
        return right;
    }
}