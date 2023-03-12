class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int[] prev = new int[n];
        for (int i = 0; i < n; i++)
            prev[i] = binarySearch(events, events[i][0]);
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[prev[i] + 1][j] + events[i][2]);
            }
        }
        return dp[n][k];
    }
    
    public int binarySearch(int[][] a, int x) {
         int l = -1, r = a.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (a[m][1] < x) l = m;
            else r = m;
        }
        return l;
    }
}