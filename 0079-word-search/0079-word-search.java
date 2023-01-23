class Solution {
    public boolean exist(char[][] board, String word) {
        /*Find word's first letter.  Then call method to check it's surroundings */
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == word.charAt(0) && dfs(board, word, 0, row, column)) {
                    return true;
                }
            } 
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int start, int row, int column) {
        /* once we get past word.length, we are done. */
        if (word.length() <= start) return true;
        /* if off bounds, letter is seen, letter is unequal to word.charAt(start) return false */
        if(row < 0 || column < 0 || row >= board.length || column >= board[0].length || board[row][column]=='0' || board[row][column] != word.charAt(start))
            return false;
        /* set this board position to seen. (Because we can use this postion) */
        char ch = board[row][column];
        board[row][column] = '0';
        /* recursion on all 4 sides for next letter, if works: return true */
        if (dfs(board, word, start + 1, row + 1, column) ||
            dfs(board, word, start + 1, row - 1, column) ||
            dfs(board, word, start + 1, row, column + 1) ||
            dfs(board, word, start + 1, row, column - 1))
            return true;
        //Set back to unseen
        board[row][column] = ch;
        return false;
    }
}