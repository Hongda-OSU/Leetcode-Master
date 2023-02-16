class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    queue.offer(new int[]{i, j});
            }
        }
        int distance = -1;
        if (queue.isEmpty() || queue.size() == n * n) 
            return -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            while (size-- > 0) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int[] dir : dirs) {
                    int i = dir[0] + x, j = dir[1] + y;
                    if (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 0) {
                        grid[i][j] = 1;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }
        return distance;
    }
}