class Solution {
    private static final int MAX_COST = 10_000_000;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target];
        for (int house = m - 1; house >= 0; house--) {
            for (int color = n - 1; color >= 0; color--) {
                int[] dpHC = dp[house][color];
                for (int nIdx = Math.min(m - house, target - 1); nIdx >= 0; nIdx--)
                    dpHC[nIdx] = MAX_COST;
            }
        }
        if (houses[0] != 0)
            dp[0][houses[0] - 1][target - 1] = 0;
        else {
            for (int color = n - 1; color >= 0; color--)
                dp[0][color][target - 1] = cost[0][color];
        }
        int lowNIdx = target - 1;
        for (int house = 1; house < m; house++) {
            int highNIdx = Math.min(m - house, target - 1);
            if (houses[house] > 0) {
                int currColor = houses[house] - 1;
                int[] dpHC = dp[house][currColor];
                for (int nIdx = highNIdx; nIdx >= lowNIdx; nIdx--) {
                    dpHC[nIdx] = Math.min(dpHC[nIdx], dp[house - 1][currColor][nIdx]);
                    if (houses[house - 1] > 0 && houses[house - 1] - 1 != currColor)
                        dpHC[nIdx - 1] = dp[house - 1][houses[house - 1] - 1][nIdx];
                    else
                        dpHC[nIdx - 1] = min(dp[house - 1], currColor, nIdx);
                }
                if (lowNIdx == 1)
                    dpHC[0] = Math.min(dpHC[0], dp[house - 1][currColor][0]);
            } else {
                    int[] costH = cost[house];
                    int[][] dpHMinus1 = dp[house - 1];
                    int prevHouseColor = houses[house - 1];
                    for (int color = n - 1; color >= 0; color--) {
                        int[] dpHC = dp[house][color];
                        for (int nIdx = highNIdx; nIdx >= lowNIdx; nIdx--) {
                            dpHC[nIdx] = Math.min(dpHC[nIdx], dpHMinus1[color][nIdx] + costH[color]);
                            if (prevHouseColor > 0 && prevHouseColor - 1 != color)
                                dpHC[nIdx - 1] = dpHMinus1[prevHouseColor - 1][nIdx] + costH[color];
                            else
                                dpHC[nIdx - 1] = min(dpHMinus1, color, nIdx) + costH[color];
                        }
                        if (lowNIdx == 1)
                            dpHC[0] = Math.min(dpHC[0], dpHMinus1[color][0] + costH[color]);
                    }
                }
                if (lowNIdx > 1) 
                    lowNIdx--;    
            }
        int min = MAX_COST;
        for (int color = n - 1; color >= 0; color--) 
            min = Math.min(min, dp[m - 1][color][0]);
        return (min < MAX_COST) ? min : -1;
    }
    
    private int min(int[][] minCosts, int curColor, int nIdx) {
        int min = Integer.MAX_VALUE;
        for (int color = minCosts.length - 1; color >= 0; color--) 
            if (color != curColor) 
                min = Math.min(min, minCosts[color][nIdx]);
        return min;
    }
}