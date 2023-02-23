class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1)
            return 0;
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        boolean[][] visited = new boolean[n][endingMask];
        ArrayList<int[]> queue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.add(new int[] {i, 1 << i});
            visited[i][1 << i] = true;
        }
        int steps = 0;
        while (!queue.isEmpty()) {
            ArrayList<int[]> next = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                int[] pair = queue.get(i);
                int node = pair[0];
                int mask = pair[1];
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    if (nextMask == endingMask)
                        return 1 + steps;
                    if (!visited[neighbor][nextMask]) {
                        visited[neighbor][nextMask] = true;
                        next.add(new int[]{neighbor, nextMask});
                    }
                }
            }
            steps++;
            queue = next;
        }
        return -1;
    }
}