class Solution {
    private TrieNode root;
    private String result = "";
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        for (String word : words)
            addWord(word);
        for (String word : words)
            searchPrefix(word);
        return result;
    } 
    
    private void addWord(String word) {
       TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch] == null)
                curr.children[ch] = new TrieNode();
            curr = curr.children[ch];
        }
        curr.isWord = true;
    }
    
    private void searchPrefix(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr = curr.children[ch];
            if (!curr.isWord)
                return;
        }
        if (result.length() < word.length() || result.length() == word.length() && result.compareTo(word) > 0)
            result = word;
    }
}
 
class TrieNode {
    public TrieNode[] children;
    public boolean isWord;
    
    public TrieNode() {
        this.children = new TrieNode[128];
    }
}