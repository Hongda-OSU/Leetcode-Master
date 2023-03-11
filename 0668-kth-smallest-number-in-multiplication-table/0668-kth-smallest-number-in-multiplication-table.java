class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n + 1;
        while (low < high) {
            int pivot = (low + high) >>> 1;
            int c = count(pivot, m, n);
            if (c >= k)
                high = pivot;
            else
                low = pivot + 1;
        }
        return high;
    }
    
    public int count(int pivot, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(pivot / i, n);
            count += temp;
        }
        return count;
    }
}