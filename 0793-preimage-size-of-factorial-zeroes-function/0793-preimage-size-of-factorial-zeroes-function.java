class Solution {
    public int preimageSizeFZF(int k) {
        long low = 0, high = (long)Math.pow(10, 10);
        while (low <= high) {
            long pivot = (low + high) >>> 1;
            long temp = pivot, result = 0;
            while (temp != 0) {
                temp /= 5;
                result += temp;
            }
            if (result == k)
                return 5;
            else if (result > k)
                high = pivot - 1;
            else 
                low = pivot + 1;
        }
        return 0;
    }
}