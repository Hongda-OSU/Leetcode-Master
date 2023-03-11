class Solution {
    public int lengthOfLIS(int[] nums) {
       if (nums == null || nums.length == 0)
           return 0;
        int n = nums.length, len = 0;
        int[] increasing = new int[n];
        increasing[len++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > increasing[len - 1]) {
                increasing[len++] = nums[i];
            } else {
                int position = findPosition(increasing, 0, len - 1, nums[i]);
                increasing[position] = nums[i];
            }
        }
        return len;
    }
    
    public int findPosition(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int pivot = (low + high) >>> 1;
            if (nums[pivot] == target)
                return pivot;
            else if (nums[pivot] > target)
                high = pivot - 1;
            else 
                low = pivot + 1;
        }
        return low;
    }
}