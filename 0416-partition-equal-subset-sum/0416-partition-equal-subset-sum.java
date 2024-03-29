class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (sum % 2 != 0) 
            return false;
        int subSetSum = sum / 2;
        boolean dp[] = new boolean[subSetSum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = subSetSum; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[subSetSum];
    } 
}