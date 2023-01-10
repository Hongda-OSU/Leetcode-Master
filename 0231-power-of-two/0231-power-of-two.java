class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long i = (long) n;
        return (i & i-1) == 0;
    }
}