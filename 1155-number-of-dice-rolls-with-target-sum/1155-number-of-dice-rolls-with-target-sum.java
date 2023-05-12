class Solution {
    private int[][] dp;
    
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return helper(n, k, target);
    }
    
    private int helper(int dices, int faces, int target) {
        int result = 0;
        if (dices == 0 && target == 0)
            return 1;
        if (target < 0 || dices <= 0)
            return 0;
        if (dp[dices][target] != -1)
            return dp[dices][target];
        for (int i = 1; i <= faces; i++) {
            result += helper(dices - 1, faces, target - i);
            if (result >= 1_000_000_007)
                result %= 1_000_000_007;
        }
        dp[dices][target] = result;
        return result;
    }
}