class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
        HashSet<List<Integer>> connectionsSet = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, connectionsSet);
        return new ArrayList<>(connectionsSet);
    }
    
    public int dfs(List<Integer>[] graph, int node, int depth, int[] rank, HashSet<List<Integer>> connectionsSet) {
        if (rank[node] >= 0)
            return rank[node];
        rank[node] = depth;
        int minDepthFound = depth;
        for (Integer neighbor : graph[node]) {
            if (rank[neighbor] == depth - 1)
                continue;
            int minDepth = dfs(graph, neighbor, depth + 1, rank, connectionsSet);
            minDepthFound = Math.min(minDepthFound, minDepth);
            if (minDepth <= depth) {
                connectionsSet.remove(Arrays.asList(node, neighbor));
                connectionsSet.remove(Arrays.asList(neighbor, node));
            }
        }
        return minDepthFound;
    }
}