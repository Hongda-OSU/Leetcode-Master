class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        HashMap<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++)
            map.put(intervals[i], i);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int j = 0; j < intervals.length; j++) {
            int[] interval = bst(intervals, intervals[j][1], 0, intervals.length - 1);
            result[map.get(intervals[j])] = interval == null ? -1 : map.get(interval);
        }
        return result;
    }
    
    public int[] bst(int[][] intervals, int target, int start, int end) {
        if (start >= end) {
            if (intervals[start][0] >= target) {
                return intervals[start];
            }
            return null;
        }
        int pivot = (start + end) >>> 1;
        if (intervals[pivot][0] < target) 
            return bst(intervals, target, pivot + 1, end);
        else 
            return bst(intervals, target, start, pivot);
    }
}