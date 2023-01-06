class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length, column = grid[0].length, fresh = 0, step = 0;
        Queue<int[]> rot = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == 1) fresh++;
                else if (grid[r][c] == 2) rot.offer(new int[]{r, c});
            }
        }
        if (fresh == 0) return 0;
        while (!rot.isEmpty()) {
            step++;
            int size = rot.size();
            for(int i = 0; i < size; i++) {
                int[] pos = rot.poll();
                int r = pos[0], c = pos[1];
                if (r - 1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    rot.offer(new int[]{r-1, c});
                    fresh--;
                }
                if (r + 1 < row && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    rot.offer(new int[]{r+1, c});
                    fresh--;
                }
                if (c - 1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    rot.offer(new int[]{r, c-1});
                    fresh--;
                }
                if (c + 1 < column && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    rot.offer(new int[]{r, c+1});
                    fresh--;
                }
            }
        }
        return fresh == 0 ? step - 1 : -1;
    }
}