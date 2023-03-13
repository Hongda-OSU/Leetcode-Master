class Solution {
    public int[][] steps = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0, 1}}; //up down left right
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length, cols = maze[0].length;
        int[][] distance = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        distance[start[0]][start[1]] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] newPos = move(i, pos[0], pos[1], maze);
                int totalDistance = distance[pos[0]][pos[1]] + newPos[2];
                if (totalDistance < distance[newPos[0]][newPos[1]]) {
                    distance[newPos[0]][newPos[1]] = totalDistance;
                    if (newPos[0] == destination[0] && newPos[1] == destination[1])
                        continue;
                    queue.add(newPos);
                }
            }
        }
        int shortestDist = distance[destination[0]][destination[1]];
        return shortestDist == Integer.MAX_VALUE ? -1 : shortestDist;
    }
    
    public int[] move(int dir, int x, int y, int[][] maze) {
        int[] pos = new int[] {x, y, 0};
        while (isValid(maze, pos[0] + steps[dir][0], pos[1] + steps[dir][1])) {
            pos[0] += steps[dir][0];
            pos[1] += steps[dir][1];
            pos[2] += 1;
        }
        return pos;
    }
    
    public boolean isValid(int[][] maze, int x, int y) {
        if (!(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length))
            return false;
        return maze[x][y] != 1;
    }
}