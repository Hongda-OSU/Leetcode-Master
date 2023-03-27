class Solution {
    public int Time = 1;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) 
            graph[i] = new ArrayList<Integer>();
        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
        int[] timestamp = new int[n];
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, graph, timestamp, 0, -1, result);
        return result;
    }
    
    public int dfs(int n, List[] graph, int[] timestamp, int i, int parent, List<List<Integer>> result) {
        if (timestamp[i] != 0)
            return timestamp[i];
        timestamp[i] = Time++;
        int minTimeStamp = Integer.MAX_VALUE;
        for (int neighbor : (List<Integer>) graph[i]) {
            if (neighbor == parent)
                continue;
            int neighborTimeStamp = dfs(n, graph, timestamp, neighbor, i, result);
            minTimeStamp = Math.min(minTimeStamp, neighborTimeStamp);
        }
        if (minTimeStamp >= timestamp[i]) {
            if (parent >= 0)
                result.add(Arrays.asList(parent, i));
        }
        return Math.min(timestamp[i], minTimeStamp);
    }
}