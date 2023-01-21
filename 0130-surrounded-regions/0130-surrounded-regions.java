class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 2 || board[0].length < 2) return;
        int rows = board.length, columns = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
	    //Start from first and last column, turn 'O' to '*'.
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O')
                boundaryDFS(board, row, 0);
            if (board[row][columns - 1] == 'O') 
                boundaryDFS(board, row, columns - 1);
        }
        //Start from first and last row, turn '0' to '*'
        for (int column = 0; column < columns; column++) {
            if (board[0][column] == 'O')
                boundaryDFS(board, 0, column);
            if (board[rows - 1][column] == 'O') 
                boundaryDFS(board, rows - 1, column); 
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == 'O')
                    board[row][column] = 'X';
                else if (board[row][column] == '*') 
                    board[row][column] = 'O';
            }
        }
    }
    
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    public void boundaryDFS(char[][] board, int row, int column) {
        int rows = board.length, columns = board[0].length;
        if (row < 0 || row > rows - 1 || column < 0 || column > columns - 1) return;
        if (board[row][column] == 'O')
            board[row][column] = '*';
        if (row > 1 && board[row - 1][column] == 'O') 
            boundaryDFS(board, row - 1, column);
        if (row < rows - 2 && board[row + 1][column] == 'O') 
            boundaryDFS(board, row + 1, column);
        if (column > 1 && board[row][column - 1] == 'O') 
            boundaryDFS(board, row, column - 1);
        if (column < columns - 2 && board[row][column + 1] == 'O') 
            boundaryDFS(board, row, column + 1);
    }
}