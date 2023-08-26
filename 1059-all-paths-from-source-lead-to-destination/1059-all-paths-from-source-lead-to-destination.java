class Solution {
    private enum State {PROCESSING, PROCESSED};
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = buildGraph(n, edges);
        return leadsToDest(graph, source, destination, new State[n]);
    }
    
    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) 
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) 
            graph[edge[0]].add(edge[1]);
        return graph;
    }
    
    private boolean leadsToDest(List<Integer>[] graph, int node, int dest, State[] states) {
        if (states[node] != null)
            return states[node] == State.PROCESSED;
        if (graph[node].isEmpty())
            return node == dest;
        states[node] = State.PROCESSING;
        for (int next : graph[node]) {
            if (!leadsToDest(graph, next, dest, states)) {
                return false;
            }
        }
        states[node] = State.PROCESSED;
        return true;
    }  
}