class WordDictionary {
    public WordDictionary[] children;
    public boolean endOfWord;

    public WordDictionary() {
        children = new WordDictionary[26];
        endOfWord = false;
    }
    
    public void addWord(String word) {
        WordDictionary curr = this;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new WordDictionary();
            curr = curr.children[ch - 'a'];
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        WordDictionary curr = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (WordDictionary wd : curr.children) {
                    if (wd != null && wd.search(word.substring(i + 1)))
                        return true;
                }
                return false;
            }
            if (curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
        }
        return curr != null && curr.endOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */