class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) 
            graph.add(new ArrayList<>());
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
            indegree[relation[1]]++;
        }
        int step = 0, studiedCount = 0;
        List<Integer> bfsQueue = new ArrayList<>();
        for (int node = 1; node < n + 1; node++) {
            if (indegree[node] == 0)
                bfsQueue.add(node);
        }
        while (!bfsQueue.isEmpty()) {
            step++;
            List<Integer> nextQueue = new ArrayList<>();
            for (int node : bfsQueue) {
                studiedCount++;
                for (int endNode : graph.get(node)) {
                    indegree[endNode]--;
                    if (indegree[endNode] == 0)
                        nextQueue.add(endNode);
                }
            }
            bfsQueue = nextQueue;
        }
        return studiedCount == n ? step : -1;
    }
}