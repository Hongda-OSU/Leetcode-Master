class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int pivot = (end + start) >>> 1;
            if (arr[pivot] > arr[pivot + 1])
                end = pivot;
            else 
                start = pivot + 1;
        }
        return start;
    }
}