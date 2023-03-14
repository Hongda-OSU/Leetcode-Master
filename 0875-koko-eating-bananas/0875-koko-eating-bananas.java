class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1_000_000_007;
        while (left < right) {
            int pivot = (left + right) >>> 1, total = 0;
            for (int pile : piles) 
                total += (pile + pivot - 1) / pivot;
            if (total > h)
                left = pivot + 1;
            else
                right = pivot;
        }
        return left;
    }
}