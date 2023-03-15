class Solution {
    public Map<Integer, List<int[]>> map = new HashMap<>();
    public int mod = 1_000_000_007;
    
    public int countRestrictedPaths(int n, int[][] edges) {
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            map.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }  
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{n, 0});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], weight = curr[1];
            for (int[] neighbor : map.get(node)) {
                int nei = neighbor[0];
                int w = weight + neighbor[1];
                if (w < dist[nei]) {
                    dist[nei] = w;
                    pq.offer(new int[]{nei, w});
                }
            }
        }
        Integer[] dp = new Integer[n + 1];
        return dfs(1, n, dist, dp);
    }
    
    public int dfs(int node, int end, int[] dist, Integer[] dp) {
        if (node == end)
            return 1;
        if (dp[node] != null)
            return dp[node];
        long result = 0;
        for (int[] neighbor : map.get(node)) {
            int nei = neighbor[0];
            if (dist[node] > dist[nei])
                result = (result + (dfs(nei, end, dist, dp)) % mod);
        }
        result = result % mod;
        return dp[node] = (int)result;
    } 
}