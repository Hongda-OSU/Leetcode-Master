class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode() {};
    public TrieNode[] children = new TrieNode[26];
    
    TrieNode(char ch) {
        TrieNode node = new TrieNode();
        node.val = ch;
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null)
                node.children[ch - 'a'] = new TrieNode(ch);
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    } 
    
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */