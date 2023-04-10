class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) 
            graph.add(new ArrayList<>());
        for (int[] relation : relations)
            graph.get(relation[0]).add(relation[1]);
        int[] visited = new int[n + 1];
        int maxLength = 1;
        for (int i = 0; i < n + 1; i++) {
            int length = dfs(i, graph, visited);
            if (length == -1)
                return -1;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
    
    public int dfs(int node,List<List<Integer>> graph, int[] visited) {
        if (visited[node] != 0)
            return visited[node];
        else
            visited[node] = -1;
        int maxLength = 1;
        for (int endNode : graph.get(node)) {
            int length = dfs(endNode, graph, visited);
            if (length == -1)
                return -1;
            maxLength = Math.max(maxLength, length + 1);
        }
        visited[node] = maxLength;
        return maxLength;
    }
}