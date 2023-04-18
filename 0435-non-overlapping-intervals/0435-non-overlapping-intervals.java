class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] arr: intervals) {
            min = Math.min(min, arr[0]);
            max = Math.max(max, arr[1]);
        }
        int[] map = new int[max + 1 - min];
        Arrays.fill(map, -1);
        for (int[] arr: intervals) {
            int index = arr[1] - min;
            if (map[index] == -1) {
                map[index] = arr[0] - min;
            } else if (map[index] < arr[0] - min) {
                map[index] = arr[0] - min;
            }
        }
        int nonOverlapCount = 0;
        int preEnd = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == -1) continue;
            if (preEnd == -1) {
                nonOverlapCount++;
                preEnd = i;
            } else {
                if (preEnd <= map[i]) {
                    nonOverlapCount++;  
                    preEnd = i;                  
                } // otherwise, use previous node              
            }
        }
        return intervals.length - nonOverlapCount;
    }
}