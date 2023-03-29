class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, curr = 0, prev = 0, zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero = 1;
                prev = curr;
                curr = 0;
            } else {
                curr++;
            }
            max = Math.max(max, curr + prev + zero);
        }
        return max;
    }
}