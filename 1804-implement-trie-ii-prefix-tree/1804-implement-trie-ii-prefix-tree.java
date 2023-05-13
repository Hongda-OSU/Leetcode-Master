class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        int pos;
        for (char ch : word.toCharArray()) {
            pos = ch - 'a';
            if (curr.children[pos] == null)
                curr.children[pos] = new Node();
            curr = curr.children[pos];
            curr.count++;
        }
        curr.end++;
    }
    
    public int countWordsEqualTo(String word) {
        Node curr = root;
        int pos;
        for (char ch : word.toCharArray()) {
            pos = ch - 'a';
            if (curr.children[pos] == null)
                return 0;
            curr = curr.children[pos];
        }
        return curr.end;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node curr = root;
        int pos;
        for (char ch : prefix.toCharArray()) {
            pos = ch - 'a';
            if (curr.children[pos] == null)
                return 0;
            curr = curr.children[pos];
        }
        return curr.count;
    }
    
    public void erase(String word) {
        Node curr = root;
        int pos;
        for (char ch : word.toCharArray()) {
            pos = ch - 'a';
            curr = curr.children[pos];
            curr.count--;
        }
        curr.end--;
    }
}

class Node {
    public Node[] children;
    public int count, end;
    
    public Node() {
        this.count = 0;
        this.end = 0;
        this.children = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */