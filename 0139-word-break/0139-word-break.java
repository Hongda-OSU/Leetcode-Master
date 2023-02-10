class Solution {
   public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        Map<String, Boolean> cache = new HashMap<>();
        return recurFind(set, s, cache);
    }
    
    private boolean recurFind(Set<String> set, String s, Map<String, Boolean> cache) {
        if (cache.containsKey(s)) return cache.get(s);
        if (set.contains(s)) return true;
        for (int i = 1; i < s.length(); i++) {
            if (set.contains(s.substring(0, i)) && recurFind(set, s.substring(i, s.length()), cache)) {
                cache.put(s, true);
                return true;   
            }
        }
        cache.put(s, false);
        return false;
    }
}