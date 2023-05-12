class Solution {
    private int[][] dp;

    public int numRollsToTarget(int dices, int faces, int target) {
        dp = new int[dices + 1][target + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return recursion(dices, faces, target);
    }

    private int recursion(int dices, int faces, int target) {
        int result = 0;
        if (dices == 0 && target == 0) {
            return 1;
        }
        if (target < 0 || dices<=0) {
            return 0;
        }
        if (dp[dices][target] != -1) {
            return dp[dices][target];
        }
        for (int i = 1; i <= faces; i++) {
            result += recursion(dices - 1, faces, target - i);

            if (result >= 1000000007) {
                result %= 1000000007;
            }
        }
        dp[dices][target] = result;
        return result;
    }
}