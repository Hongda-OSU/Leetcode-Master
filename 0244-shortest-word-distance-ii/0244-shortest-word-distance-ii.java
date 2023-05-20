class WordDistance {
    private Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (map.containsKey(word)) 
                map.get(word).add(i);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(word, list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1), l2 = map.get(word2);
        int result = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < l1.size() && j < l2.size(); ) {
            int idx1 = l1.get(i), idx2 = l2.get(j);
            if (idx1 < idx2) {
                result = Math.min(result, idx2 - idx1);
                i++;
            } else {
                result = Math.min(result, idx1 - idx2);
                j++;
            }
        }
        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */