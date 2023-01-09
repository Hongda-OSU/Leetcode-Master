class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] robAmount = new int[len + 1];
        robAmount[len] = 0;
        robAmount[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            robAmount[i] = Math.max(robAmount[i+1], robAmount[i+2] + nums[i]);
        }
        return robAmount[0];
    } 
}