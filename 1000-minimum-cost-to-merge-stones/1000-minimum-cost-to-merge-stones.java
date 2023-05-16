class Solution {
    private Integer[][][] memo;
    private int[] preSum;
    
    public int mergeStones(int[] stones, int k) {
        if (stones == null || stones.length == 0)
            return 0;
        int n = stones.length;
        if (n == 1)
            return 0;
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + stones[i];
        if (n == k)
            return preSum[n];
        if ((n - 1) % (k - 1) != 0)
            return -1;
        memo = new Integer[n][n][k + 1];
        for (int i = 0; i < n; i++)
            memo[i][i][1] = 0;
        return helper(stones, 0, n - 1, 1, k);
    } 
    
    private int helper(int[] stones, int i, int j, int piles, int k) {
        if ((j - i + 1 - piles) % (k - 1) != 0)
            return Integer.MAX_VALUE;
        if (memo[i][j][piles] != null)
            return memo[i][j][piles];
        int result = Integer.MAX_VALUE;
        if (piles == 1) {
            int prev = helper(stones, i, j, k, k);
            if (prev != Integer.MAX_VALUE)
                result = prev + preSum[j + 1] - preSum[i];
        } else {
            for (int mid = i; mid < j; mid++) {
                int left = helper(stones, i, mid, 1, k);
                if (left >= result)
                    continue;
                int right = helper(stones, mid + 1, j, piles - 1, k);
                if (right >= result)
                    continue;
                result = Math.min(result, left + right);
            }
        }
        memo[i][j][piles] = result;
        return result;
    }
}