class Trie {
    Trie[] child;
    int wordCount = 0;

    public Trie() {
        child = new Trie[26];
    }
    
    public void insert(String word) {
        Trie temp = this;
        for(int i = 0; i < word.length(); i++) {
            if(temp.child[word.charAt(i) - 'a'] == null) {    // If its null means, we need to create a new brach from that point.
                temp.child[word.charAt(i) - 'a'] = new Trie();
            }
            temp = temp.child[word.charAt(i) - 'a'];
            if(i == word.length()-1) {  // Change boolean to int to record the number of words
                temp.wordCount++;
            }
        }
    }
    
    public int countWordsEqualTo(String word) {
        boolean isFound = false;
        Trie temp = this;
        int wordCount = 0;
        for(int i = 0; i < word.length(); i++) {
            if(temp.child[word.charAt(i) - 'a'] == null) {
                return 0;
            } else {
                if(i == word.length()-1 && temp.child[word.charAt(i) - 'a'].wordCount != 0) {
                    isFound = true;
                    wordCount = temp.child[word.charAt(i) - 'a'].wordCount;
                }
            }
            temp = temp.child[word.charAt(i) - 'a'];
        }
        return wordCount;//Find the end point of the word in the Trie and output wordCount of that Node
    }
    
    public int countWordsStartingWith(String prefix) {
        Trie temp = this;
        for(int i = 0; i < prefix.length(); i++) {
            if(temp.child[prefix.charAt(i) - 'a'] == null) { // If the path doesn't exist, just end the search and break at this point.
                return 0;
            }
            temp = temp.child[prefix.charAt(i) - 'a'];
        }
        //The code above helps us to find the endpoint of 'Prefix", after that we could count from this as root
        return count(temp);
    }
    
    private int count(Trie root) {
        int res = 0;
        res += root.wordCount;
        for (Trie trie: root.child) {
            if (trie != null) {
                res += count(trie);
            }
        }
        return res;
    }// Recursively get the cumulative sum
    
    public void erase(String word) {
        Trie temp = this;
        if (countWordsEqualTo(word) == 0) {
            return;
        }
        for(int i = 0; i < word.length(); i++) {
            if(i == word.length()-1 && temp.child[word.charAt(i) - 'a'].wordCount != 0) {
                temp.child[word.charAt(i) - 'a'].wordCount--;// Find the endpoint, decrease the count by 1
            }
            temp = temp.child[word.charAt(i) - 'a'];
        }
        return;
        
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