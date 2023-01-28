class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // current interval starts first & not covered by newInterval, add intervals[i] to ans
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            // newInterval starts first and not covered by current interval
            // add newInterval to ans and set newInterval = curInterval
            } else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = interval;
            // they are overlapped, merge them
            } else if (interval[0] <= newInterval[1] || interval[1] >= newInterval[0]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        // add the last interval
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}