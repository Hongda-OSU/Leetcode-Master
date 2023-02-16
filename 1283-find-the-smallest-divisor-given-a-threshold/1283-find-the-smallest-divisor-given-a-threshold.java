class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = nums[0], result = 0;
        for (int num : nums)
            high = Math.max(high, num);
        while (low <= high) {
            int pivot = (low + high) >>> 1;
            int sum = divisionSum(nums, pivot);
            if (sum <= threshold) {
                high = pivot - 1;
                result = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return result;
    }
    
    public int divisionSum(int[] nums, int pivot) {
        int result = 0;
        for (int num : nums) 
            result += Math.ceil(num * 1.0 / pivot);
        return result;
    }
}