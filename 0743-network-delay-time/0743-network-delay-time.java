class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, k});
        boolean[] visited = new boolean[n + 1];
        int result = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int node = curr[1];
            int dist = curr[0];
            if (visited[node])
                continue;
            visited[node] = true;
            result = dist;
            n--;
            if (n == 0)
                return result;
            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet())
                    pq.add(new int[]{dist + map.get(node).get(next), next});
            }
        } 
        return -1;
    }
}