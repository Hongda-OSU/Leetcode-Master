class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] columns = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        // set up 9 rows, 9 columns, 9 boxes
        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if(board[r][c] == '.') continue;
                char ch = board[r][c];
                if (rows[r].contains(ch)) return false;
                rows[r].add(ch);
                if (columns[c].contains(ch)) return false;
                columns[c].add(ch);
                int index = (r / 3) * 3 + c / 3;
                if (boxes[index].contains(ch)) return false;
                boxes[index].add(ch);
            }
        }
        return true;
    }
}