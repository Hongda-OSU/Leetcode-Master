class Solution {
    public int minDistance(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length, B[] = new int[n+1], dp[] = new int[n];
        for (int i = 0; i < n; ++i) {
            B[i + 1] = B[i] + A[i];
            dp[i] = (int)1e6;
        }
        for (int k = 1; k <= K; ++k) {
            for (int j = n - 1; j > k - 2; --j) {
                for (int i = k - 2; i < j; ++i) {
                    int m1 =  (i + j + 1) / 2, m2 = (i + j + 2) / 2;
                    int last = (B[j + 1] - B[m2]) - (B[m1 + 1] - B[i + 1]);
                    dp[j] = Math.min(dp[j], (i >= 0 ? dp[i] : 0) + last);
                }
            }
        }
        return dp[n - 1];
    }
}