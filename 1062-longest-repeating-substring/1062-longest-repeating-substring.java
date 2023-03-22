class Solution {
    public int longestRepeatingSubstring(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        TrieNode root = new TrieNode();
        for (int i = 0; i < arr.length; i++) {
            TrieNode curr = root;
            for (int j = i; j < arr.length; j++) {
                if (curr.next[arr[j] - 'a'] == null) {
                    TrieNode node = new TrieNode();
                    curr.next[arr[j] - 'a'] = node;
                    curr = node;
                } else {
                    result = Math.max(result, j - i + 1);
                    curr = curr.next[arr[j] - 'a'];
                }
            }
        }
        return result;
    }
}

class TrieNode {
    public TrieNode[] next;
    
    public TrieNode() {
        next = new TrieNode[26];
    }
}