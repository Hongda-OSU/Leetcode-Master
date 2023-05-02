class Solution {
    private int numLimit, targetTotal;
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        numLimit = maxChoosableInteger;
        targetTotal = desiredTotal;
        int max = (numLimit * (numLimit + 1)) / 2;
        if (max < targetTotal)
            return false;
        int[] dp = new int[(1 << numLimit)];
        if (solve(0, 0, 0, dp))
            return true;
        return false;
    }
    
    private boolean solve(int mask, int lstSum, int player, int[] dp) {
        if (dp[mask] != 0)
            return dp[mask] == 1;
        for (int i = 0; i < numLimit; i++) {
            if ((mask & (1 << i)) == 0) {
                if (lstSum + i + 1 >= targetTotal || !solve(mask | (1 << i), lstSum + i + 1, player + 1, dp)) {
                    dp[mask] = 1;
                    return true;
                }   
            }
        }
        dp[mask] = -1;
        return false;
    }
} 