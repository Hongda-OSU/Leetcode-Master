class Solution {
    public int maxFrequency(int[] nums, int k) {
        int left = 0, sum = 0, max = 0;
        Arrays.sort(nums);
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left];
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}