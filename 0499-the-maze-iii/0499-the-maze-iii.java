class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        char[] turns = {'d', 'u', 'r', 'l'};
        int rows = maze.length, cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.dist == p2.dist)
                    return p1.path.compareTo(p2.path);
                else
                    return p1.dist - p2.dist;
            }
        });
        minHeap.add(new Point(ball[0], ball[1], 0, ""));
        while (!minHeap.isEmpty()) {
            Point curr = minHeap.poll();
            int row = curr.row, col = curr.col;
            if (row == hole[0] && col == hole[1])
                return curr.path;
            if (visited[row][col])
                continue;
            visited[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int r = row, c = col, dist = curr.dist;
                while (r >= 0 && r < rows && c >= 0 && c < cols && maze[r][c] == 0 && (r != hole[0] || c != hole[1])) {
                    r += dirs[i][0];
                    c += dirs[i][1];
                    dist++;
                }
                if (r != hole[0] || c != hole[1]) {
                    r -= dirs[i][0];
                    c -= dirs[i][1];
                    dist--;
                }
                if (!visited[r][c]) 
                    minHeap.add(new Point(r, c, dist, curr.path + turns[i]));
            }
        }
        return "impossible";
    }
}

class Point {
    public int row, col, dist;
    public String path;
    
    public Point(int r, int c, int d, String p) {
        this.row = r;
        this.col = c;
        this.dist = d;
        this.path = p;
    }
}