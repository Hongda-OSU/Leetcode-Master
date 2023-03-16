class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int col = Math.min(mat[0].length, k);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            PriorityQueue<Integer> nextPQ = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : pq) {
                for (int j = 0; j < col; j++) {
                    nextPQ.add(i + row[j]);
                    if (nextPQ.size() > k)
                        nextPQ.poll();
                }
            }
            pq = nextPQ;
        }
        return pq.poll();
    }
}