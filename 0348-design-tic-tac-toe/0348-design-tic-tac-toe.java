class TicTacToe {
    private int[] rows, cols;
    private int diagonal, antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int curr = (player == 1) ? 1 : -1;
        rows[row] += curr;
        cols[col] += curr;
        if (row == col)
            diagonal += curr;
        if (col == (cols.length - row - 1))
            antiDiagonal += curr;
        int n = rows.length;
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n 
            || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n)
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */