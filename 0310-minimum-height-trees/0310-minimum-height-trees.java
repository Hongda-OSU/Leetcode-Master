class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] edgeList = new ArrayList[n];
        for (int i = 0; i < n; i++)
            edgeList[i] = new ArrayList<>();
        for (int[] edge : edges) {
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        int p1 = bfs(edgeList, 0, prev);
        prev = new int[n];
        Arrays.fill(prev, -1);
        int p2 = bfs(edgeList, p1, prev);
        List<Integer> path = new ArrayList<>();
        int i = p2;
        while (i != p1) {
            path.add(i);
            i = prev[i];
        }
        path.add(p1);
        List<Integer> result = new ArrayList<>();
        result.add(path.get(path.size() / 2));
        if (path.size() % 2 == 0)
            result.add(path.get(path.size() / 2 - 1));
        return result;
    }
    
    public int bfs(List<Integer>[] edgeList, int start, int[] prev) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        prev[start] = start;
        int result = start;
        while (!queue.isEmpty()) {
            result = queue.poll();
            for (int edge : edgeList[result]) {
                if (prev[edge] == -1) {
                    queue.add(edge);
                    prev[edge] = result;
                }
            }
        }
        return result;
    } 
}