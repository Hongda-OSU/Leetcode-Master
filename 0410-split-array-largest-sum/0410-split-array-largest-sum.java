class Solution {
    public int splitArray(int[] nums, int k) {
        int min = Integer.MIN_VALUE, max = 0;
        for (int num : nums) {
            min = Math.max(min, num);
            max += num;
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canSplit(mid, nums, k))
                max = mid;
            else
                min = mid + 1;
        }
        return min;
    }
    
    public boolean canSplit(int upperBoundSubarraySum, int[] nums, int k) {
        int currSubarraySum = 0, cntSubarray = 1;
        for (int num : nums) {
            currSubarraySum += num;
            if (currSubarraySum > upperBoundSubarraySum) {
                cntSubarray++;
                currSubarraySum = num;
                if (cntSubarray > k)
                    return false;
            }
        }
        return true;
    } 
}