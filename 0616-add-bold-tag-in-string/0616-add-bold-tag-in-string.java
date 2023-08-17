class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        
        TrieNode() {
            children = new HashMap<>();
        }
        
        public String toString() {
            return children.toString() + " - " + isWord;
        }
    }
    
    class Trie {
        TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        public void add(String word) {
            int len = word.length();
            TrieNode ptr = root;
            for (int i = 0; i < len; ++ i) {
                char c = word.charAt(i);
                if (!ptr.children.containsKey(c)) {
                    ptr.children.put(c, new TrieNode());
                }
                ptr = ptr.children.get(c);
            }
            ptr.isWord = true;
        }
        
        public int search(String s, int i) {
            int end = -1, len = s.length();
            TrieNode ptr = root;
            while (i < len) {
                char c = s.charAt(i);
                if (!ptr.children.containsKey(c)) {
                    return end;
                }
                
                ptr = ptr.children.get(c);
                if (ptr.isWord) {
                    end = i;
                }
                
                ++ i;
                
            }
            
            return end;
        }
    }
    
    public String addBoldTag(String s, String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.add(word);
        }
        
        int len = s.length(), maxEnd = -1;
        boolean[] isBold = new boolean[len];
        
        for (int i = 0; i < len; ++ i) {
            int end = trie.search(s, i);
            maxEnd = Math.max(maxEnd, end);
            isBold[i] = maxEnd >= i;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean state = false;
        for (int i = 0; i < len; ++ i) {
            if (isBold[i] != state) {
                state = !state;
                if (state) {
                    sb.append("<b>");
                } else {
                    sb.append("</b>");
                }
            }
            sb.append(s.charAt(i));
        }
        if (state) {
            sb.append("</b>");
        }
        
        return sb.toString();
    }
}