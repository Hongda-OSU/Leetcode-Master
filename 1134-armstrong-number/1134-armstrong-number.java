class Solution {
    public boolean isArmstrong(int n) {
        int length = String.valueOf(n).length();
        return getSumOfKthPowerOfDigits(n, length) == n;
    }
    
    private int getSumOfKthPowerOfDigits(int n, int k) {
        int result = 0;
        while (n != 0) {
            result += Math.pow(n % 10, k);
            n /= 10;
        }
        return result;
    }
}