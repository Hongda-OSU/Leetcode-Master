class Solution {
    public int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        List<Coord> buildings = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    buildings.add(new Coord(j, i, 0));
                grid[i][j] = -grid[i][j];
            }
        }
        for (int k = 0; k < buildings.size(); k++)
            bfs(buildings.get(k), k, dist, grid, m, n);
        int result = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == buildings.size() && (result < 0 || dist[i][j] < result))
                    result = dist[i][j];
            }
        }
        return result;
    }
    
    public void bfs(Coord coord, int k, int[][] dist, int[][] grid, int m, int n) {
        Queue<Coord> queue = new LinkedList<>();
        queue.add(coord);
        while (!queue.isEmpty()) {
            Coord curr = queue.poll();
            dist[curr.y][curr.x] += curr.dist;
            for (int i = 0; i < 4; i++) {
                int x = curr.x + dx[i], y = curr.y + dy[i];
                if (x >= 0 && y >= 0 && x < n && y < m && grid[y][x] == k) {
                    grid[y][x] = k + 1;
                    queue.add(new Coord(x, y, curr.dist + 1));
                }
            }
        }
    }
}

class Coord {
    public int x, y, dist;
    
    public Coord(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}