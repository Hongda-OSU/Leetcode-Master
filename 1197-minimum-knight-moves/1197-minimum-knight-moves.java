class Solution {
    public int minKnightMoves(int x, int y) {
        final int[][] MOVE = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        x = Math.abs(x);
        y = Math.abs(y);
        final int sizeX = x + 4, sizeY = y+4;
        boolean [][] board = new boolean[sizeX][sizeY];
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,0});
        board[2][2] = true;
        while (!q.isEmpty()){
            int[] n = q.poll();
            int count = n[2];
            if (n[0] == x && n[1] == y)
                return count;
            ++count;
            for (int[] move: MOVE){
                int i = n[0] + move[0]+ 2, j = n[1]+move[1] + 2;
                if (i <0 || j <0 || i>=sizeX ||j >=sizeY || board[i][j])
                    continue;
                board[i][j] = true;
                q.add(new int[]{i-2, j-2, count});
            }
        }
        return -1;
    }
}