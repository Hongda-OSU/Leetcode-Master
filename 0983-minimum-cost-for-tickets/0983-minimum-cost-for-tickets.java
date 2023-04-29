class Solution {
    private static int[] days, costs;
    private static Integer[] memo;
    private static final int[] durations = new int[]{1, 7, 30};
    
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];
        return dp(0);
    }
    
    private int dp(int i) {
        if (i >= days.length)
            return 0;
        if (memo[i] != null)
            return memo[i];
        int result = Integer.MAX_VALUE, j = i;
        for (int k = 0; k < 3; k++) {
            while (j < days.length && days[j] < days[i] + durations[k])
                j++;
            result = Math.min(result, dp(j) + costs[k]);
        }
        memo[i] = result;
        return result;
    }
}