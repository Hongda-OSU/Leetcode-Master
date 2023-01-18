class Solution {
    public int findCircleNum(int[][] isConnected) {
        int numProvinces = 0;
        // note: isConnected[i][j] == 1 means ith city connect with jth city
        // dfs each node, ie: first row
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == false) {
                dfs(isConnected, visited, i);
                numProvinces++;
            }
        }
        return numProvinces;
    }
    
    public void dfs(int[][] isConnected, boolean[] visited, int i) {
        // since it's an n * n matrix, then i is row, j is column, imax == jmax
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}