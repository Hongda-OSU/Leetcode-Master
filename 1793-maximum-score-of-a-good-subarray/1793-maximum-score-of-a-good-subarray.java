class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k - 1, right = k + 1;
        int min = nums[k], result = min;
        while (left >= 0 || right < n) {
            int tmp1 = 0, tmp2 = 0;
            int min1 = min, min2 = min;
            if (left >= 0) {
                min1 = Math.min(min, nums[left]);
                tmp1 = min1 * (right - left);
            }
            if (right < n) {
                min2 = Math.min(min, nums[right]);
                tmp2 = min2 * (right - left);
            }
            if (tmp1 > tmp2) {
                left -= 1;
                result = Math.max(tmp1, result);
                min = Math.min(min1, min);
            } else {
                right += 1;
                result = Math.max(tmp2, result);
                min = Math.min(min2, min);
            }
        }
        return result;
    }
}