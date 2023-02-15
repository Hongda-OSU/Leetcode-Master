class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) 
            right = Math.max(right, pile);
        while (left < right) {
            int pivot = (left + right) >>> 1;
            int hour = 0;
            for (int pile : piles)
                hour += Math.ceil((double)pile / pivot);
            if (hour <= h)
                right = pivot;
            else 
                left = pivot + 1;
        }
        return right;
    }
}