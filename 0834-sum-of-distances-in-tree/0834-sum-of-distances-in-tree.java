class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) 
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] countArr = new int[n];
        countNodes(graph, 0, countArr, new boolean[n]);
        int[] distance = new int[n];
        distance[0] = rootDistance(graph, 0, countArr, new boolean[n]);
        calcDistances(graph, 0, countArr, distance, new boolean[n]);
        return distance;
    }
    
    public int countNodes(ArrayList<Integer>[] graph, int idx, int[] countArr, boolean[] visited) {
        visited[idx] = true;
        int count = 1;
        for (int neighbor : graph[idx]) {
            if (visited[neighbor] == false)
                count += countNodes(graph, neighbor, countArr, visited);
        }
        countArr[idx] = count;
        return count;
    }
    
    public int rootDistance(ArrayList<Integer>[] graph, int idx, int[] countArr, boolean[] visited) {
        visited[idx] = true;
        int dist = 0;
        for (int neighbor : graph[idx]) {
            if (visited[neighbor] == false)
                dist += rootDistance(graph, neighbor, countArr, visited) + countArr[neighbor];
        }
        return dist;
    }
    
    public void calcDistances(ArrayList<Integer>[] graph, int idx, int[] countArr, int[] distance, boolean[] visited) {
        visited[idx] = true;
        for (int neighbor : graph[idx]) {
            if (visited[neighbor] == false) {
                distance[neighbor] = distance[idx] + graph.length - 2 * countArr[neighbor];
                calcDistances(graph, neighbor, countArr, distance, visited);
            }
        }
    }
}