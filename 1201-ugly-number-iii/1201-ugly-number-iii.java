class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 1, right = Integer.MAX_VALUE, count = 0;
        while (left < right) {
            int pivot = (left + right) >>> 1;
            if (isUgly(pivot, a, b, c, n))
                right = pivot;
            else 
                left = pivot + 1;
        }
        return left;
    }
    
    public boolean isUgly(long pivot, long a, long b, long c, long n) {
         return (int) (pivot / a + pivot / b + pivot / c - pivot / lcm(a, b) 
                       - pivot / lcm(b, c) - pivot / lcm(c, a) + pivot / lcm(a, lcm(b, c))) >= n;
    }
    
    public long lcm(long a, long b) {
        return a * b / (gcd(a, b));
    }
    
    public long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}