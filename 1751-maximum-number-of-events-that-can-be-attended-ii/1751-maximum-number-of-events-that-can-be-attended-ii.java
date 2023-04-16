class Solution {
    public int maxValue(int[][] events, int k) {
        int max = 0;
        if (k == 1) {
            for (int[] event : events)
                max = Math.max(max, event[2]);
            return max;
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int size = events.length;
        int[][] cache = new int[size + 1][k + 1];
        for (int i = size - 1; i >= 0; i--) {
            int next = binarySearch(events, events[i][1], i + 1, size);
            for (int j = 1; j <= k; j++)
                cache[i][j] = Math.max(cache[i + 1][j], cache[next][j - 1] + events[i][2]);
        }
        return cache[0][k];
    }
    
    private int binarySearch(int[][] events, int target, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target >= events[mid][0])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}