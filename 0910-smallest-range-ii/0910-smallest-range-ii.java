class Solution {
    public int smallestRangeII(int[] nums, int k) {
        /*
        1 2 3 4 5 6 7 8 9
        + + + - - - - - -
        The maximum = Math.max(lmax + k, rmax - k)
        The minimum = Math.min(lmin + k, rmin - k)
        */
        Arrays.sort(nums);
        int score = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            score = Math.min(score, getScore(nums, k, i));
        }
        return score;
    }
    private int getScore(int[] nums, int k, int i) {
        if (i == 0) {
            return nums[nums.length - 1] - nums[0];
        }
        int max = Math.max(nums[i - 1] + k, nums[nums.length - 1] - k);
        int min = Math.min(nums[0] + k, nums[i] - k);
        return max - min;
    }
}