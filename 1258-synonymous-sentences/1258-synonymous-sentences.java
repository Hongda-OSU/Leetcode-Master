class Solution {
    Map<String, String> parent = new HashMap<>();
    Map<String, List<String>> sets = new HashMap<>();
    
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> result = new ArrayList<>();
        for (List<String> pair : synonyms) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            union(word1, word2);
        }
        for (Map.Entry<String, String> entry : parent.entrySet()) {
            String word = (String)entry.getKey();
            String par = find(word);
            if (!sets.containsKey(par))
                sets.put(par, new ArrayList<>());
            sets.get(par).add(word);
        }
        String[] texts = text.split(" ");
        String[] comb = new String[texts.length];
        findCombination(text.split(" "), 0, comb, result);
        Collections.sort(result, (a, b) -> a.compareTo(b));
        return result;
    }
    
    public void union(String word1, String word2) {
        String par1 = find(word1);
        String par2 = find(word2);
        if (par1.compareTo(par2) < 0)
            parent.put(par2, par1);
        else
            parent.put(par1, par2);
    }
    
    public String find(String word) {
        if (!parent.containsKey(word)) {
            parent.put(word, word);
            return word;
        }
        if (!parent.get(word).equals(word)) 
            parent.put(word, find(parent.get(word)));
        return parent.get(word);
    }
    
    public void findCombination(String[] texts, int index, String[] comb, List<String> result) {
        if (index == texts.length) {
            result.add(String.join(" ", comb));
            return;
        }
        if (!parent.containsKey(texts[index])) {
            comb[index] = texts[index];
            findCombination(texts, index + 1, comb, result);
        } else {
            String par = find(texts[index]);
            List<String> equalwords = sets.get(par);
            for (String equalword : equalwords) {
                comb[index] = equalword;
                findCombination(texts, index + 1, comb, result);
            }
        }
    }
}