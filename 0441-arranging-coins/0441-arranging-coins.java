class Solution {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        while (left <= right) {
            long k = (left + right) >>> 1;
            // 1 + 2 + ... + k(k+1) / 2
            long curr = k * (k + 1) / 2;
            if (curr == n) return (int)k;
            if (curr < n) 
                left = k + 1;
            else
                right = k - 1;
        }
        return (int)right;
    }
}