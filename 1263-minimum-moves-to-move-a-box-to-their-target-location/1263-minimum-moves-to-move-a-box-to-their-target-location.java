class Solution {
    public char[][] g;
    public int m, n;
    public int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int minPushBox(char[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        int step = 0;
        boolean[][][] visited = new boolean[m][n][4];
        int[] st = new int[]{-1, -1}, ed = new int[]{-1, -1}, pl = new int[]{-1, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 'B') 
                    st = new int[]{i, j};
                if (g[i][j] == 'T') 
                    ed = new int[]{i, j};
                if (g[i][j] == 'S') 
                    pl = new int[]{i, j};
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{st[0], st[1], pl[0], pl[1]});
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == ed[0] && curr[1] == ed[1])
                    return step;
                for (int j = 0; j < 4; j++) {
                    if (visited[curr[0]][curr[1]][j])
                        continue;
                    int[] dir = dirs[j];
                    int x0 = curr[0] + dir[0], y0 = curr[1] + dir[1];
                    if (x0 < 0 || x0 >= m || y0 < 0 || y0 >= n || g[x0][y0] == '#')
                        continue;
                    int x1 = curr[0] - dir[0], y1 = curr[1] - dir[1];
                    if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || g[x1][y1] == '#')
                        continue;
                    if (!reachable(x0, y0, curr))
                        continue;
                    visited[curr[0]][curr[1]][j] = true;
                    queue.offer(new int[]{x1, y1, curr[0], curr[1]});
                }
            }
            step++;
        }
        return -1;
    }
    
    public boolean reachable(int x, int y, int[] curr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{curr[2], curr[3]});
        boolean[][] visited = new boolean[m][n];
        visited[curr[0]][curr[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == x && cur[1] == y)
                return true;
            for (int[] dir : dirs) {
                int r = cur[0] - dir[0], c = cur[1] - dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || g[r][c] == '#')
                    continue;
                visited[r][c] = true;
                queue.offer(new int[]{r, c});
            }
        }
        return false;
    } 
}