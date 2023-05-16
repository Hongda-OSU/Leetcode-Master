public class Solution {
    Integer[][][] memo;
    int[] preSum;

    public int mergeStones(int[] stones, int K) {
        if (stones == null || stones.length == 0) return -1;

        int n = stones.length;
        if (n == 1) return 0;
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }

        if (n == K) {
            return preSum[n];
        }

        if ((n - 1) % (K - 1) != 0) return -1;

        memo = new Integer[n][n][K + 1];
        for (int i = 0; i < n; i++) {
            memo[i][i][1] = 0;
        }

        return calculate(stones, 0, n - 1, 1, K);
    }

    private int calculate(int[] stones, int i, int j, int piles, int K) {
        if ((j - i + 1 - piles) % (K - 1) != 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j][piles] != null) {
            return memo[i][j][piles];
        }
        int cost = Integer.MAX_VALUE;
        if (piles == 1) {
            int prev = calculate(stones, i, j, K, K);
            if (prev != Integer.MAX_VALUE) {
                cost = prev + preSum[j + 1] - preSum[i];
            }
        } else {
            for (int mid = i; mid < j; mid++) {
                int left = calculate(stones, i, mid, 1, K);
                if (left >= cost) continue;
                int right = calculate(stones, mid + 1, j, piles - 1, K);
                if (right >= cost) continue;
                cost = Math.min(cost, left + right);
            }
        }
        memo[i][j][piles] = cost;
        return cost;
    }
}