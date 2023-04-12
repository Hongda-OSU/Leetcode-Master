class Solution {
    private Map<String, Boolean> map;
    
    public String longestWord(String[] words) {
        map = new HashMap<>();
        Set<String> dictionary = new HashSet<>();
        for (String word : words) 
            dictionary.add(word);
        Arrays.sort(words, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        for (String word : words) {
            if (dfs(word, 0, dictionary))
                return word;
        }
        return "";
    }
    
    private boolean dfs(String word, int idx, Set<String> dictionary) {
        if (map.containsKey(word))
            return map.get(word);
        if (idx == word.length()) {
            map.put(word, true);
            return true;
        }
        if (dictionary.contains(word.substring(0, idx + 1))) 
            return dfs(word, idx + 1, dictionary);
        return false;
    }
}