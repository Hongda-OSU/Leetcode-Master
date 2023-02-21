class Solution {
    public int waysToSplit(int[] nums) {
        int size = nums.length, result = 0, mod = 1_000_000_007;
        for (int i = 1; i < size; i++)
            nums[i] += nums[i - 1];
        for (int i = 0; i < size - 2; i++) {
            int left = searchLeft(nums, i, size - 1);
            int right = searchRight(nums, i, size - 1);
            if (left == -1 || right == -1)
                continue;
            result = (result + right - left + 1) % mod;
        }
        return result;
    }
    
    public int searchLeft(int[] nums, int left, int right) {
        int pos = -1, min = nums[left], low = left + 1, high = right - 1;
        while (low <= high) {
            int pivot = (low + high) >>> 1;
            int mid = nums[pivot] - min;
            int max = nums[right] - nums[pivot];
            if (mid < min) 
                low = pivot + 1;
            else if (mid > max)
                high = pivot - 1;
            else {
                pos = pivot;
                high = pivot - 1;
            }              
        }
        return pos;
    }
    
    public int searchRight(int[] nums, int left, int right) {
        int pos = -1, min = nums[left], low = left + 1, high = right - 1;
        while (low <= high) {
            int pivot = (low + high) >>> 1;
            int mid = nums[pivot] - min;
            int max = nums[right] - nums[pivot];
            if (mid < min) 
                low = pivot + 1;
            else if (mid > max)
                high = pivot - 1;
            else {
                pos = pivot;
                low = pivot + 1;
            }              
        }
        return pos;
    }
}