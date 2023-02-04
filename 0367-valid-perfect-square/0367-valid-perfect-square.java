class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 2, right = num / 2;
        while (left <= right) {
            long pivot = (left + right) >>> 1;
            long sqrt = pivot * pivot;
            if (sqrt == num)
                return true;
            else if (sqrt < num)
                left = pivot + 1;
            else 
                right = pivot - 1;
        }
        return false;
    } 
}