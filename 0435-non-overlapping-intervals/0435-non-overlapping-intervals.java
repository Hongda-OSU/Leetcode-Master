class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int result = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // if current start smaller than previous end,
            // remove current
            if (intervals[i][0] < prev) {
                result++;
            } else {
                prev = intervals[i][1];
            }    
        }
        return result;
    }
}