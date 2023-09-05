class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int temp = result * 10 + tail;
            if ((temp - tail) / 10 != result) {
                return 0;
            }
            result = temp;
            x /= 10;
        }
        return result;
    }
}