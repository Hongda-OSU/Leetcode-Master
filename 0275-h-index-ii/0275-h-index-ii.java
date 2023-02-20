class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int pivot = (low + high) >>> 1;
            if (citations[pivot] == len - pivot) 
                return len - pivot;
            else if (citations[pivot] < len - pivot)
                low = pivot + 1;
            else 
                high = pivot - 1;
        }
        return len - low;
    }
}