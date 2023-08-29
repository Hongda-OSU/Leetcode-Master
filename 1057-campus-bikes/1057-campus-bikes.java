class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length, n = bikes.length;
        int[] wo = new int[m], bi = new int[n];
        Arrays.fill(wo, -1);
        Arrays.fill(bi, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
             return a[0] != b[0] ? a[0] - b[0]
                    : (a[1] != b[1] ? a[1] - b[1]
                       : (a[2] - b[2]));
        });
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] worker = workers[i];
                int[] bike = bikes[j];
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                pq.offer(new int[]{dist, i, j});
            }
        }
        int assigned = 0;
        while (!pq.isEmpty() && assigned < m) {
            int[] curr = pq.poll();
            if (wo[curr[1]] == -1 && bi[curr[2]] == -1) {
                wo[curr[1]] = curr[2];
                bi[curr[2]] = curr[1];
                assigned++;
            }
        }
        return wo;
    }
}