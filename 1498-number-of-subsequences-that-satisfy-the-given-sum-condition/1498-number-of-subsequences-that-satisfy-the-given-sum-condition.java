class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, result = 0;
        int[] power = new int[nums.length + 1];
        power[0] = 1;
        for (int i = 1; i <= nums.length; i++)
            power[i] = (power[i - 1] * 2) % mod;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }   
        return result;
    }
}