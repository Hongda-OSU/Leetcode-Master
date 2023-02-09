class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        for (int i = 0; i < m; i++) {
            int soliders = binarySearch(mat[i]);
            pq.add(new int[]{soliders, i});
            if (pq.size() > k) 
                pq.poll();
        } 
        int[] kWeakest = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            int[] pair = pq.poll();
            kWeakest[i] = pair[1];
        }
        return kWeakest;
    }
    
    public int binarySearch(int[] row) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int pivot = (left + right) >>> 1;
            if (row[pivot] == 1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        // since left is the index of pivot (solider)
        return left;
    }  
}