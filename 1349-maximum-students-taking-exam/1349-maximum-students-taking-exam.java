class Solution {
    private int m, n;
    private Integer[][] match;
    private int[][] seen;
    private static final int[][] dirs = {{0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    
    public int maxStudents(char[][] seats) {
        m = seats.length;
        n = seats[0].length;
        match = new Integer[m][n];
        seen = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') {
                    result++;
                    if (match[i][j] == null)
                        result -= dfs(seats, i, j, seen[i][j] = i * n + j);
                }
            }
        }
        return result;
    }
    
    private int dfs(char[][] seats, int x, int y, int v) {
        for (int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if (dx >= 0 && dx < m && dy >= 0 && dy < n && seats[dx][dy] == '.' && seen[dx][dy] != v) {
                seen[dx][dy] = v;
                if (match[dx][dy] == null || dfs(seats, match[dx][dy] / n, match[dx][dy] % n, v) == 1) {
                    match[x][y] = dx * n + dy;
                    match[dx][dy] = x * n + y;
                    return 1;
                }
            }
        }
        return 0;
    }
}