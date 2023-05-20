class WordDistance {
    private Map<String, List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i ++) {
            String word = words[i];
            List<Integer> list = map.getOrDefault(word, new LinkedList<Integer>());
            list.add(i);
            map.put(word, list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int min = Integer.MAX_VALUE;
        for (int index1 : list1) {
            for (int index2 : list2) {
                min = Math.min(min, (int)Math.abs(index1 - index2));
            }
        }
        
        return min;
    }
}
/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */