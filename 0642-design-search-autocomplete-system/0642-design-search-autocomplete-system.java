class AutocompleteSystem {
    static class TrieNode implements Comparable<TrieNode>{
        private TrieNode[] children;
        private int sentHitFreq; // If this is end of sentence, hit freq > 0. Else, 0.
        private List<TrieNode> hotList; // Holds top 3 sentences that travel via this node.
        private String sentence; // Last node of sentence also stores the sentence.
        
        TrieNode(){
            sentence = null;
            sentHitFreq = 0;
            children = new TrieNode[27]; // Idx 26 is used for ' '.
            hotList = new ArrayList<>(3);
        }
        
        public int compareTo(TrieNode that){
            if(this.sentHitFreq == that.sentHitFreq){
                return this.sentence.compareTo(that.sentence);
            }
            
            return that.sentHitFreq - this.sentHitFreq; // Desc order.
        }
        
        void updateHotList(TrieNode sentEndNode){
            if(!hotList.contains(sentEndNode)){ // Adding a sentence node that already exists would be erroneous.
                hotList.add(sentEndNode);
            }
            
            Collections.sort(hotList); // Implemented compareTo will be used.
            
            if(hotList.size() > 3){
                hotList.remove(hotList.size() - 1);
            }
        }
    }
    
    private TrieNode root;
    private TrieNode iterNodeThatRemembers; // Picks up where left off & doesn't always start from root unless reset.
    private StringBuilder inpStr;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        iterNodeThatRemembers = root;
        inpStr = new StringBuilder();
        
        for(int idx = 0; idx < sentences.length; ++idx){
            addSentence(sentences[idx], times[idx]);
        }
    }
    
    private void addSentence(String sent, int times){
        TrieNode iterNode = root;
        List<TrieNode> visitedNodes = new ArrayList<>();
        
        for(int idx = 0; idx < sent.length(); ++idx){
            int idxInChildArr = getArrIdxForChar(sent.charAt(idx));
            
            if(iterNode.children[idxInChildArr] == null){
                iterNode.children[idxInChildArr] = new TrieNode();
            }
            
            iterNode = iterNode.children[idxInChildArr];        
            visitedNodes.add(iterNode);
        }
        
        // Reached the end of setence. The last node holds the hit freq and the sentence itelf.
        iterNode.sentHitFreq += times;
        iterNode.sentence = sent;
        
        for(TrieNode nodeInPath: visitedNodes){
            nodeInPath.updateHotList(iterNode); // As new sentence went via this node, hotList needs updating.
        }
    }
    
    public List<String> input(char c) {
        List<String> retHotList = new ArrayList<>();
        
        if(c == '#'){
            addSentence(inpStr.toString(), 1); // 1 might get summed with hitFreq if sentence already in history.
            iterNodeThatRemembers = root; // Reset.
            inpStr = new StringBuilder(); // Reset.
            return retHotList;
        }
        
        inpStr.append(c);        
        
        int idxInChildArr = getArrIdxForChar(c);
        if(iterNodeThatRemembers != null){
            iterNodeThatRemembers = iterNodeThatRemembers.children[idxInChildArr];
        }
        
        if(iterNodeThatRemembers == null){
            return retHotList; // If input char doesn't exist in any prefix path, return empty list.
        }
        
        for(TrieNode sentEndNode: iterNodeThatRemembers.hotList){
            retHotList.add(sentEndNode.sentence); // Input char exists in prefix path. Populate retList with hotList.
        }
        
        return retHotList;
    }
    
    private int getArrIdxForChar(char c){
            return c == ' ' ? 26 : c - 'a';
        }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */