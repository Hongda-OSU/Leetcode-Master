class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        Integer[] colors = new Integer[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colors[i] == null && !dfs(graph, colors, i, 1))
                return false;
        }
        return true;
    }
    
    public boolean dfs(List<Integer>[] graph, Integer[] colors, int currNode, int currColor) {
        colors[currNode] = currColor;
        for (Integer adj : graph[currNode]) {
            if (colors[adj] == null) {
                if (!dfs(graph, colors, adj, currColor * -1))
                    return false;
            } else if (colors[adj] == currColor) {
                return false;
            }
        }
        return true;
    }
}