class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        long sqrt = 0;
        int left = 2, right = x / 2;
        while (left <= right) {
            int pivot = (left + right) >>> 1;
            sqrt = (long)pivot * pivot;
            if (sqrt < x)
                left = pivot + 1;
            else if (sqrt > x)
                right = pivot - 1;
            else 
                return pivot;
        }   
        return right;
    }
}