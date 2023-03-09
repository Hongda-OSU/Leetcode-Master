class Solution {
    public int maxLength(int[] ribbons, int k) {
        int max = Integer.MIN_VALUE;
        for (int ribbon : ribbons) 
            max = Math.max(max, ribbon);
        int low = 1, high = max;
        while (low <= high) {
            int pivot = (low + high) >>> 1;
            int count = 0;
            for (int ribbon : ribbons)
                count += ribbon / pivot;
            if (count < k)
                high = pivot - 1;
            else
                low = pivot + 1;
        }
        return high > 0 ? high : 0;
    }
}