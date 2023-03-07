class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = (left + right) >>> 1;
            if (nums[pivot] - nums[0] - pivot < k) 
                left = pivot + 1;
            else 
                right = pivot - 1;
        }
        return k + right + nums[0];
    }
}