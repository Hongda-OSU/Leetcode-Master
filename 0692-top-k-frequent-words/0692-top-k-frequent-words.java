class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) 
            map.put(word, map.getOrDefault(word, 0) + 1);
        List<String> list = new ArrayList<>(map.keySet());
        //if two words have the same frequency, then the word with the lower alphabetical order comes first.
        //else most frequent words will come first
        Collections.sort(list, (l1, l2) -> map.get(l1).equals(map.get(l2)) ? l1.compareTo(l2) : map.get(l2) - map.get(l1));
        return list.subList(0, k);
    }
}