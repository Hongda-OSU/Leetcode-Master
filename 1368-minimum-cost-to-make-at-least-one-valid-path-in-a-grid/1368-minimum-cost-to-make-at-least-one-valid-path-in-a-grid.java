class Solution {
    public int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int minCost(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int cost = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        Queue<int[]> bfs = new LinkedList<>();
        dfs(grid, 0, 0, dp, cost, bfs);
        while (!bfs.isEmpty()) {
            cost++;
            for (int size = bfs.size(); size > 0; size--) {
                int[] curr = bfs.poll();
                int r = curr[0], c = curr[1];
                for (int i = 0; i < 4; i++) 
                    dfs(grid, r + dirs[i][0], c + dirs[i][1], dp, cost, bfs);
            }
        }
        return dp[rows - 1][cols - 1];
    }
    
    public void dfs(int[][] grid, int r, int c, int[][] dp, int cost, Queue<int[]> bfs) {
        int rows = grid.length, cols = grid[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols || dp[r][c] != Integer.MAX_VALUE)
            return;
        dp[r][c] = cost;
        bfs.offer(new int[]{r, c});
        int nextDir = grid[r][c] - 1;
        dfs(grid, r + dirs[nextDir][0], c + dirs[nextDir][1], dp, cost, bfs);
    }
}