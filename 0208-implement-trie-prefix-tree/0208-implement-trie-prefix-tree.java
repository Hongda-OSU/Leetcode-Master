class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if (curr.children[id] == null) 
                curr.children[id] = new TrieNode();
            curr = curr.children[id];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, true);
    }
    
    public boolean startsWith(String prefix) {
        return searchHelper(prefix, false);
    }
    
    private boolean searchHelper(String str, boolean search) {
        TrieNode curr = root;
        int i = -1, len = str.length();
        while (++i < len) {
            int id = str.charAt(i) - 'a';
            if ((curr = curr.children[id]) == null)
                return false;
        }
        return search ? curr.isEnd : true;
    }
}

class TrieNode {
    public boolean isEnd;
    public TrieNode[] children;
    
    public TrieNode() {
        children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */