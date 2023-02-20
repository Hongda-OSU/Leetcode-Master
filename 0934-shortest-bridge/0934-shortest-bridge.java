class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n && q.isEmpty(); i++) {
            for (int j = 0; j < n && q.isEmpty(); j++) {
                if (grid[i][j] == 1)
                    dfs(grid, i, j, q);
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int i = dir[0] + curr[0], j = dir[1] + curr[1];
                if (i < 0 || i == n || j < 0 || j == n || grid[i][j]==-1) 
                    continue;
                if (grid[i][j] == 1)
                    return curr[2];
                grid[i][j] = -1;
                q.add(new int[]{i, j, curr[2] + 1}); //increase distance
            }
        } 
        return -1;
    }
    
    public void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        int n = grid.length;
        if (i < 0 || i == n || j < 0 || j == n || grid[i][j] != 1)
            return;
        grid[i][j] = -1;
        q.add(new int[]{i, j, 0}); //0 distance travelled
        dfs(grid, i - 1, j, q);
        dfs(grid, i + 1, j, q);
        dfs(grid, i, j - 1, q);
        dfs(grid, i, j + 1, q);
    }
}