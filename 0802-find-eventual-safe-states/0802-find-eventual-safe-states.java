class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, color, graph))
                result.add(i);
        }
        return result;
    }
    
    // colors: WHITE 0, GRAY 1, BLACK 2;
    public boolean dfs(int i, int[] color, int[][] graph) {
        if (color[i] > 0)
            return color[i] == 2;
        color[i] = 1;
        for (int neighbor : graph[i]) {
            if (color[i] == 2)
                continue;
            if (color[neighbor] == 1 || !dfs(neighbor, color, graph))
                return false;
        }
        color[i] = 2;
        return true;
    } 
}