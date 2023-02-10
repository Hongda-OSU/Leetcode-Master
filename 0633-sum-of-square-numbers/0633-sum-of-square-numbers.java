class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0, right = (long) Math.sqrt(c);
        while (left <= right) {
            long curr = left * left + right * right;
            if (curr < c)
                left++;
            else if (curr > c)
                right--;
            else 
                return true;
        }
        return false;
    }
}