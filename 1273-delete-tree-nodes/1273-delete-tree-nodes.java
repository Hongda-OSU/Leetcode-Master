class Solution {
    public int deleteTreeNodes(int n, int[] parent, int[] value) {
        List<List<Integer>> graph = new ArrayList<>(n); // Create graph for the tree
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++)
            if (parent[i] != -1)
                graph.get(parent[i]).add(i);

        return dfs(graph, value, 0)[1];
    }
    private int[] dfs(List<List<Integer>> graph, int[] value, int root) { // return [sum, cnt of remain nodes after deleted]
        int totalSum = value[root];
        int totalNodes = 1;
        for (int child : graph.get(root)) {
            int[] temp = dfs(graph, value, child);
            totalSum += temp[0];
            totalNodes += temp[1];
        }
        if (totalSum == 0) totalNodes = 0; // This subtree should be removed, so don't count nodes of this subtree
        return new int[]{totalSum, totalNodes};
    }
}