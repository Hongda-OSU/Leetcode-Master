class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] redEdge : redEdges) 
            adj.computeIfAbsent(redEdge[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(redEdge[1], 0));
        for (int[] blueEdge : blueEdges)
            adj.computeIfAbsent(blueEdge[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(blueEdge[1], 1));
        int[] result = new int[n];
        Arrays.fill(result, -1);
        boolean[][] visited = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, -1});
        result[0] = 0;
        visited[0][1] = visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] element = q.poll();
            int node = element[0], steps = element[1], prevColor = element[2];
            if (!adj.containsKey(node))
                continue;
            for (List<Integer> nei : adj.get(node)) {
                int neighbor = nei.get(0);
                int color = nei.get(1);
                if (!visited[neighbor][color] && color != prevColor) {
                    if (result[neighbor] == -1)
                        result[neighbor] = 1 + steps;
                    visited[neighbor][color] = true;
                    q.offer(new int[] {neighbor, 1 + steps, color});
                }
            }
        }
        return result;
    }
}