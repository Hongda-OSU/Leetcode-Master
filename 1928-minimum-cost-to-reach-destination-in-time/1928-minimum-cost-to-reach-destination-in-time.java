class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) 
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, passingFees[0], 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int fee = curr[1];
            int time = curr[2];
            if (time >= minTime[node] || time > maxTime) 
                continue;
            if (node == n - 1)
                return fee;
            minTime[node] = time;
            for (int[] edge : graph[node]) {
                int e_node = edge[0];
                int e_time = time + edge[1];
                int e_fee = fee + passingFees[e_node];
                pq.offer(new int[]{e_node, e_fee, e_time});
            }
        }
        return -1;
    }
}