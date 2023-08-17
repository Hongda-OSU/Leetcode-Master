class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            int prevEnd = intervals[i - 1][1];
            int currStart = intervals[i][0];
            if (prevEnd > currStart) {
                return false;
            }
        }
        
        
        return true;
    }
}