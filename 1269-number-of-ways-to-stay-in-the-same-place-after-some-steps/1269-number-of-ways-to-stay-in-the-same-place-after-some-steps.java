class Solution {
    public int numWays(int steps, int arrLen) {
        int[][] memo = new int[steps + 1][steps + 1];
        return helper(steps, arrLen, 0, memo);
    }
    
    private int helper(int moves, int n, int i, int[][] memo) {
        if (i > moves) 
            return 0;
        if (moves == 0 && i == 0)
            return 1;
        if (memo[moves][i] != 0)
            return memo[moves][i];
        int result = 0, mod = 1_000_000_007;
        result = helper(moves - 1, n, i, memo) % mod;
        if (i > 0) 
            result = (result % mod + helper(moves - 1, n, i - 1, memo) % mod) % mod;
        if (i < n - 1)
            result = (result % mod + helper(moves - 1, n, i + 1, memo) % mod) % mod;
        memo[moves][i] = result;
        return result;
    }
}