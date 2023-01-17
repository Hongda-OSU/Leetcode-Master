class Solution {
    public boolean increasingTriplet(int[] nums) {
        // min1 < min2
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min1) min1 = num;
            else if (num < min2) min2 = num;
            else if (num > min2) return true;
        }
        return false;
    }
}