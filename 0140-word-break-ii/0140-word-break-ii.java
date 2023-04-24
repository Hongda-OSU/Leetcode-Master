class Solution {
    private int[] dict;
    private Trie root;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        dict = new int[26];
        List<String> result = new ArrayList<>();
        for (String word : wordDict)
            root.addWord(word, dict);
        for (char ch : s.toCharArray()) {
            if (dict[ch - 'a'] != 1)
                return new ArrayList<>();
        }
        search(result, root, new StringBuilder(), s.toCharArray(), 0);
        return result;
    }
    
    private void search(List<String> result, Trie curr, StringBuilder sb, char[] arr, int index) {
        if (index == arr.length)
            return;
        if (curr.children[arr[index] - 'a'] == null)
            return;
        Trie next = curr.children[arr[index] - 'a'];
        sb.append(arr[index]);
        if (next.isWord) {
            if (index + 1 == arr.length) {
                result.add(sb.toString());
                sb.deleteCharAt(sb.length() - 1);
                return;
            } else {
                sb.append(" ");
                search(result, root, sb, arr, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        search(result, next, sb, arr, index + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
    
}

class Trie{
    public boolean isWord;
    public Trie[] children;
    
    public Trie() {
        this.children = new Trie[26];
    }
    
    public void addWord(String word, int[] dict) {
        Trie curr = this;
        int index = 0;
        char[] arr = word.toCharArray();
        while (index < arr.length) {
            dict[arr[index] - 'a'] = 1;
            if (curr.children[arr[index] - 'a'] == null)
                curr.children[arr[index] - 'a'] = new Trie();
            curr = curr.children[arr[index] - 'a'];
            index++;
        }
        curr.isWord = true;
    }
}