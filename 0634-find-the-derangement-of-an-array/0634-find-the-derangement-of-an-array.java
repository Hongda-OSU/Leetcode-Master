class Solution {
     final static int mod = (int)1e9 + 7;
    public int findDerangement(int n) {
        if (n <= 2) return n - 1;
        long preDp = 0;
        long dp = 1;
        for (int i = 3; i <= n; i++) {
            long temp = dp;
            dp = (i - 1) * (dp + preDp) % mod;
            preDp = temp;
        }
        return (int)dp;
    }
}