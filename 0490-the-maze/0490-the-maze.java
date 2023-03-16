class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length, cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return dfs(maze, start[0], start[1], destination, visited);
    }
    
    public boolean dfs(int[][] maze, int row, int col, int[] destination, boolean[][] visited) {
        if (row == destination[0] && col == destination[1])
            return true;
        if (visited[row][col])
            return false;
        visited[row][col] = true;
        return move(maze, row, col, destination, visited, 1, 0) ||
            move(maze, row, col, destination, visited, -1, 0) ||
            move(maze, row, col, destination, visited, 0, 1) ||
            move(maze, row, col, destination, visited, 0, -1);
    }
    
    public boolean move(int[][] maze, int row, int col, int[] destination, boolean[][] visited, int drow, int dcol) {
        int rows = maze.length, cols = maze[0].length;
        int r = row, c = col;
        while (r + drow >= 0 && r + drow <= rows - 1 && c + dcol >= 0 && c + dcol <= cols - 1 && maze[r + drow][c + dcol] == 0) {
            r = r + drow;
            c = c + dcol;
        }
        return dfs(maze, r, c, destination, visited);
    }
}