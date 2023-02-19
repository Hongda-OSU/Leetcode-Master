class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Arrays.stream(bloomDay).min().getAsInt(), 
            high = Arrays.stream(bloomDay).max().getAsInt(), 
            result = -1;
        while (low <= high) {
            int pivot = (low + high) >>> 1;
            if(makeBouquest(bloomDay, m, k, pivot)) {
                result = pivot;
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return result;
    }
    
    public boolean makeBouquest(int[] bloomDay, int m, int k, int pivot) {
        int bouquets = 0, flowersCollected = 0;
        for (int value : bloomDay) {
            if (value <= pivot) 
                flowersCollected++;
            else 
                flowersCollected = 0;
            
            if (flowersCollected == k) {
                bouquets++;
                flowersCollected = 0;
            }
        }
        return bouquets >= m;
    }
}