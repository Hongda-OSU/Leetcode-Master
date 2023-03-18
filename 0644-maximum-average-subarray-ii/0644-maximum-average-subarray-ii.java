class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0)
            return Integer.MIN_VALUE;
        double min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
            if (nums[i] > max)
                max = nums[i];
        }
        while (min <= max) {
            double pivot = min + (max - min) / 2.0;
            if (hasAvgAbove(nums, k, pivot)) 
                min = pivot + 0.000_005;
            else
                max = pivot - 0.000_005;
        }
        return max;
    }
    
    public boolean hasAvgAbove(int[] nums, int k, double target) {
        double sum = 0, extraSum = 0;
        for (int i = 0; i < k; i++) 
            sum += nums[i] - target;
        int curr = k;
        while (curr < nums.length) {
            if (sum >= 0)
                return true;
            sum += nums[curr] - target;
            extraSum += nums[curr - k] - target;
            if (extraSum < 0) {
                sum -= extraSum;
                extraSum = 0;
            }
            curr++;
        }
        return sum >= 0;
    }
}