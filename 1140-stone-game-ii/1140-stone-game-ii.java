class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[] preSum = Arrays.copyOf(piles, len);
        for (int i = len - 2; i >= 0; i--)
            preSum[i] += preSum[i + 1];
        return dfs(preSum, 1, 0, new int[len][len]);
    }
    
    private int dfs(int[] preSum, int m, int p, int[][] memo) {
        if (p + 2 * m >= preSum.length)
            return preSum[p];
        if (memo[p][m] > 0)
            return memo[p][m];
        int result = 0, take = 0;
        for (int i = 1; i <= 2 * m; i++) {
            take = preSum[p] - preSum[p + i];
            result = Math.max(result, take + preSum[p + i] - dfs(preSum, Math.max(i, m), p + i, memo));
        }
        memo[p][m] = result;
        return result;
    }
}