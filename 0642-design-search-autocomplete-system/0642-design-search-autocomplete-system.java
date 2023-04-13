class AutocompleteSystem {
    private TrieNode root, iterNodeRemember;
    private StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        iterNodeRemember = root;
        sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) 
            addSentence(sentences[i], times[i]);
    }
    private void addSentence(String sentence, int times) {
        TrieNode iterNode = root;
        List<TrieNode> visited = new ArrayList<>();
        for (int i = 0; i < sentence.length(); i++) {
            int index = getIndex(sentence.charAt(i));
            if (iterNode.children[index] == null)
                iterNode.children[index] = new TrieNode();
            iterNode = iterNode.children[index];
            visited.add(iterNode);
        }
        iterNode.hitFreq += times;
        iterNode.sentence = sentence;
        for (TrieNode node : visited)
            node.updateHotList(iterNode);
    }
    
    private int getIndex(char ch) {
        return ch == ' ' ? 26 : ch - 'a';
    }
    
    public List<String> input(char ch) {
        List<String> hotList = new ArrayList<>();
        if (ch == '#') {
            addSentence(sb.toString(), 1);
            iterNodeRemember = root;
            sb = new StringBuilder();
            return hotList;
        }
        sb.append(ch);
        int index = getIndex(ch);
        if (iterNodeRemember != null)
            iterNodeRemember = iterNodeRemember.children[index];
        if (iterNodeRemember == null)
            return hotList;
        for (TrieNode node : iterNodeRemember.hotList) 
            hotList.add(node.sentence);
        return hotList;
    }
}

class TrieNode implements Comparable<TrieNode> {
    public TrieNode[] children;
    public int hitFreq;
    public List<TrieNode> hotList;
    public String sentence;
    
    public TrieNode() {
        this.sentence = null;
        this.hitFreq = 0;
        this.children = new TrieNode[27];
        this.hotList = new ArrayList<>(3);
    }
    
    public int compareTo(TrieNode node) {
        if (this.hitFreq == node.hitFreq)
            return this.sentence.compareTo(node.sentence);
        return node.hitFreq - this.hitFreq;
    }
    
    public void updateHotList(TrieNode node) {
        if (!this.hotList.contains(node))
            this.hotList.add(node);
        Collections.sort(this.hotList);
        if (this.hotList.size() > 3)
            this.hotList.remove(this.hotList.size() - 1);
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */