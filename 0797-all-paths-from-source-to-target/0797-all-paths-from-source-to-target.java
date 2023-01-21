class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph.length == 0) return result;
        List<Integer> path = new ArrayList<>();
        path.add(0); //adding starting 0th node initially
        dfs(graph, 0, path, result);
        return result;        
    }
    
    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        if (node == graph.length - 1) { //node is index in graph i.e. each row or individual sub list
            result.add(new ArrayList(path)); //when it reaches to end(graph.lenght-1) then add that path to res
            return; 
        }
        for (int n : graph[node]) { //traversing on each sublist or and finding path from that again
            path.add(n);
            dfs(graph, n, path, result);
            path.remove(path.size() - 1); //backtracking
        }
    }
}