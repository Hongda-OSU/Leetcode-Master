class Solution {
    int T = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // use a timestamp, for each node, check the samllest timestamp that can reach from the node
        // construct the graph first
        List[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (List<Integer> conn : connections) {
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }
        
        int[] timestamp = new int[n]; // an array to save the timestamp that we meet a certain node
        
        // for each node, we need to run dfs for it, and return the smallest timestamp in all its children except its parent
        List<List<Integer>> criticalConns = new ArrayList<>();
        dfs(n, graph, timestamp, 0, -1, criticalConns);
        return criticalConns;
    }
    
    // return the minimum timestamp it ever visited in all the neighbors
    private int dfs(int n, List[] graph, int[] timestamp, int i, int parent, List<List<Integer>> criticalConns) {
        if (timestamp[i] != 0) return timestamp[i];
        timestamp[i] = T++;

        int minTimestamp = Integer.MAX_VALUE;
        for (int neighbor : (List<Integer>) graph[i]) {
            if (neighbor == parent) continue; // no need to check the parent
            int neighborTimestamp = dfs(n, graph, timestamp, neighbor, i, criticalConns);
            minTimestamp = Math.min(minTimestamp, neighborTimestamp);
        }
        
        if (minTimestamp >= timestamp[i]) {
            if (parent >= 0) criticalConns.add(Arrays.asList(parent, i));
        }
        return Math.min(timestamp[i], minTimestamp);
    }
}