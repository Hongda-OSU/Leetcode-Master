class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int max = Integer.MIN_VALUE, result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                // if current element can be added to dp array.
                if (nums[j] < nums[i]) {
                    //count is copied directly bcz, it is creating new sequence by adding jth element. and hence whatever the count of lis j has, now i will also has
                    if (dp[i] < dp[j] + 1) {
                        count[i] = count[j];
                        dp[i] = dp[j] + 1;
                    //it means same length lis found again. hence update count wih total occurence of jth element.
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        } 
        // count the number of LIS
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max)
                result += count[i];
        }
        return result;
    }
}