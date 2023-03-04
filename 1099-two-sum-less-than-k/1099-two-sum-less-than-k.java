class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, result = -1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                result = Math.max(result, sum);
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}