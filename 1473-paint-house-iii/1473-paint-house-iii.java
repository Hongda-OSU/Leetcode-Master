class Solution {
    // Value beyond the max possible total cost (10^6), which is 
    // the highest cost[] value (10^4) times max number of 
    // houses (10^2).  So we use 10^7 as the value beyond all 
    // possible maximum total cost.
    static final int MAX_COST = 10_000_000;

    public int minCost(int[] houses, int[][] cost, int houseCount, 
                                int colorCount, int target) {
        // Declare and initialize dp[][][] array to one past the maximum 
        // possible total cost of painting the max possible number of 
        // houses all at the most expensive cost of the paints.
        int[][][] dp = new int[houseCount][colorCount][target];
        for (int house = houseCount - 1; house >= 0; house--) {
            for (int color = colorCount - 1; color >= 0; color--) {
                int[] dpHC = dp[house][color];
                for (int nIdx = Math.min(houseCount - house, target - 1); nIdx >= 0; nIdx--) 
                    dpHC[nIdx] = MAX_COST;
            }
        }

        // Initialize the first part of the dp[][][] array as zero cost 
        // for leaving it the same color, or the costs of all the colors 
        // if the first house is unpainted.
        if (houses[0] != 0) {
            dp[0][houses[0] - 1][target - 1] = 0;
        } else {
            for (int color = colorCount - 1; color >= 0; color--) 
                dp[0][color][target - 1] = cost[0][color];
        }

        // The neighborhood indices start at "target-1" and work their way down 
        // to "0".  The target number of neighborhoods can be found at dp[][][0] 
        // in the dynamic programming array.
        int lowNIdx = target - 1;

        // Loop through all the houses from the second house to the last house.  
        // The first house has been previously initialized into the dp[][][] array.
        for (int house = 1; house < houseCount; house++) {
            // The high neighborhood index (highNIdx) is always set to target-1, 
            // unless we are near the end of the houses.  Near the end of the houses, 
            // the highest neighborhood index values can no longer contribute to 
            // neighborhood index of zero values, which are the result values for 
            // the dp[][][] array.
            int highNIdx = Math.min(houseCount - house, target - 1);

            // If the current house is already painted, we may or may not change 
            // its color.
            if (houses[house] > 0) {
                int curColor = houses[house] - 1;
                int[] dpHC = dp[house][curColor];
                // Loop through all of the neighborhood indexes that are 
                // currently in-use.
                for (int nIdx = highNIdx; nIdx >= lowNIdx; nIdx--) {
                    // Cost if same color as previous house's color.  i.e. In the 
                    // same neighborhood.  Store value at current neighborhood index.
                    dpHC[nIdx] = Math.min(dpHC[nIdx], 
                                            dp[house - 1][curColor][nIdx]);
                    // Cost if changing to a different color than the previous house.
                    // i.e. Starting a new neighborhood.  Store value at next (descending 
                    // index value is "next") neighborhood index.
                    if (houses[house - 1] > 0 && houses[house - 1] - 1 != curColor) 
                        dpHC[nIdx - 1] = dp[house - 1][houses[house - 1] - 1][nIdx];
                     else 
                        dpHC[nIdx - 1] = min(dp[house - 1], curColor, nIdx);
                }

                if (lowNIdx == 1)
                    dpHC[0] = Math.min(dpHC[0], dp[house - 1][curColor][0]);
            // Else the current house has never been painted and needs some paint.
            } else {
                // Loop through all possible colors to paint the current house.
                // Loop through all neighborhood indexes that are currently in-use.
                int[] costH = cost[house];
                int[][] dpHMinus1 = dp[house - 1];
                int prevHouseColor = houses[house - 1];
                for (int color = colorCount - 1; color >= 0; color--) {
                    int[] dpHC = dp[house][color];
                    for (int nIdx = highNIdx; nIdx >= lowNIdx; nIdx--) {
                        // Cost if same color as previous house's color.  i.e. In the 
                        // same neighborhood.  Store value at current neighborhood index.
                        dpHC[nIdx] = Math.min(dpHC[nIdx], dpHMinus1[color][nIdx] + costH[color]);
                        // Cost if changing to a different color than the previous house.
                        // i.e. Starting a new neighborhood.  Store value at next (descending 
                        // index value is "next") neighborhood index.
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

        // Find the minimum cost for the last house, for all possible colors, 
        // at the target neighborhood count.
        int min = MAX_COST;
        for (int color = colorCount - 1; color >= 0; color--) 
            min = Math.min(min, dp[houseCount - 1][color][0]);

        return (min < MAX_COST) ? min : -1;
    }

    
    // Find the mimimum total cost to repaint a house a new color.  
    // The house index is selected by the passed dp[house] that comes in
    // as minCosts[][].
    private int min(int[][] minCosts, int curColor, int nIdx) {
        int min = Integer.MAX_VALUE;
        for (int color = minCosts.length - 1; color >= 0; color--) 
            if (color != curColor) 
                min = Math.min(min, minCosts[color][nIdx]);
        return min;
    }
}