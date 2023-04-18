class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }
        int[] map = new int[max + 1 - min];
        Arrays.fill(map, -1);
        for (int[] interval : intervals) {
            int idx = interval[1] - min;
            if (map[idx] == -1)
                map[idx] = interval[0] - min;
            else if (map[idx] < interval[0] - min)
                map[idx] = interval[0] - min;
        }
        int nonOverlapCount = 0, preEnd = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == -1)
                continue;
            if (preEnd == -1) {
                nonOverlapCount++;
                preEnd = i;
            } else {
                if (preEnd <= map[i]) {
                    nonOverlapCount++;
                    preEnd = i;
                }
            }
        }
        return intervals.length - nonOverlapCount;
    }
}