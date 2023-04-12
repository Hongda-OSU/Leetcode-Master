class Solution {
    private char[][] board;
    private List<String> result;
    
    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character ch : word.toCharArray()) {
                if (node.children.containsKey(ch))
                    node = node.children.get(ch);
                else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(ch, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        this.board = board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (root.children.containsKey(board[row][col]))
                    backtrack(row, col, root);
            }
        }
        return result;
    }
    
    private void backtrack(int row, int col, TrieNode node) {
        Character ch = board[row][col];
        TrieNode curr = node.children.get(ch);
        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null;
        }
        board[row][col] = '#';
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i], newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0|| newCol >= board[0].length) 
                continue;
            if (curr.children.containsKey(board[newRow][newCol]))
                backtrack(newRow, newCol, curr);
        }
        board[row][col] = ch;
        if (curr.children.isEmpty())
            node.children.remove(ch);
    }
}

class TrieNode {
    public HashMap<Character, TrieNode> children;
    public String word;
    
    public TrieNode() {
        children = new HashMap<>();
    }
}