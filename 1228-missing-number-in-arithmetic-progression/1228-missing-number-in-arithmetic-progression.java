class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int diff = (arr[n - 1] - arr[0]) / n;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == arr[0] + mid * diff) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[0] + diff * low;
    }
}