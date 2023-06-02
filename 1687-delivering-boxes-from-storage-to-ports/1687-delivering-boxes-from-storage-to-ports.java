class Solution {
    public int boxDelivering(int[][] A, int portsCount, int B, int W) {
        int n = A.length, need = 0, j = 0, lastj = 0, dp[] = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            while (j < n && B > 0 && W >= A[j][1]) {
                B -= 1;
                W -= A[j][1];
                if (j == 0 || A[j][0] != A[j - 1][0]) {
                    lastj = j;
                    need++;
                }
                dp[++j] = 200000;
            }
            dp[j] = Math.min(dp[j], dp[i] + need + 1);
            dp[lastj] = Math.min(dp[lastj], dp[i] + need);
            B += 1;
            W += A[i][1];
            if (i == n - 1 || A[i][0] != A[i + 1][0]) {
                need--;
            }
        }
        return dp[n];
    }
}