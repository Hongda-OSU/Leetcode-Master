class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] graph = new int[n][n];
        int[] indegree = new int[n];
        for (int[] road : roads) {
            indegree[road[0]]++;
            indegree[road[1]]++;
            graph[road[0]][road[1]] = 1;
            graph[road[1]][road[0]] = 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                result = Math.max(result, indegree[i] + indegree[j] - graph[i][j]);
            }
        }
        return result;
    }
}