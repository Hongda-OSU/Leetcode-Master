/**
the same as 
[2123. Minimum Operations to Remove Adjacent Ones in Matrix](https://leetcode.com/problems/minimum-operations-to-remove-adjacent-ones-in-matrix/)  (Bipartile, boy girl and girl boy matches, Hungarian, unweighted) 
 */
class Solution {
    int m, n;
    Integer[][] match;
    int[][] seen;
    private static final int[][] dirs = {{0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public int maxStudents(char[][] seats) {
        m = seats.length;
        n = seats[0].length;

        match = new Integer[m][n];
        seen = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') {
                    ans++;
                    if (match[i][j] == null) 
                        ans -= dfs(seats, i, j, seen[i][j] = i * n + j);
                }
            }
        }
        return ans;
    }

    private int dfs(char[][] seats, int x, int y, int v) {
        for (int[] dir : dirs) {
            int tx = x + dir[0];
            int ty = y + dir[1];
            // only invisted girls with whom the boy has connection and has not invited before
            if (tx >= 0 && tx < m && ty >= 0 && ty < n && seats[tx][ty] == '.' && seen[tx][ty] != v) {
                seen[tx][ty] = v;
                if (match[tx][ty] == null || dfs(seats, match[tx][ty] / n, match[tx][ty] % n, v) == 1) {
                    match[x][y] = tx * n + ty;
                    match[tx][ty] = x * n + y;
                    return 1;
                }
            }
        }
        return 0;
    }
}