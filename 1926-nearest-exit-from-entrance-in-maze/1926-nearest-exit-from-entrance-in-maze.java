class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int step = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0], y = curr[1] + dir[1];
                    if (x < 0 || x >= rows || y < 0 || y >= cols)
                        continue;
                    if (maze[x][y] == '+')
                        continue;
                    if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1)
                        return step;
                    maze[x][y] = '+';
                    q.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}