class Solution {
    private static int mod = (int)1e9 + 7;
    
    public int findDerangement(int n) {
        if (n <= 2)
            return n - 1;
        long prev = 0, dp = 1;
        for (int i = 3; i <= n; i++) {
            long tmp = dp;
            dp = (i - 1) * (dp + prev) % mod;
            prev = tmp;
        }
        return (int)dp;
    }
}