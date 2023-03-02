class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        Map<String, String> parent = new HashMap<>();
        if (sentence1.length != sentence2.length)
            return false;
        for (List<String> pair : similarPairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            union(word1, word2, parent);
        }
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if (!word1.equals(word2) && !find(word1, parent).equals(find(word2, parent))) 
                return false;
        }
        return true;
    }
    
    public void union(String s1, String s2, Map<String, String> parent) {
        String x = find(s1, parent);
        String y = find(s2, parent);
        if (!x.equals(y))
            parent.put(x, y);
    }
    
    public String find(String word, Map<String, String> parent) {
        if (!parent.containsKey(word))
            parent.put(word, word);
        if (!parent.get(word).equals(word))
            parent.put(word, find(parent.get(word), parent));
        return parent.get(word);
    }
} 