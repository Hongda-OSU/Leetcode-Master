class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> map = new HashMap<>();
        return canConstruct(s, wordDict, map);
    }
    
    public boolean canConstruct(String str, List<String> wordDict, HashMap<String, Boolean> map) {
        if (map.containsKey(str)) 
            return map.get(str);
        if (str.isEmpty())
            return true;
        for (String word : wordDict) {
            if (str.startsWith(word)) {
                if (canConstruct(str.substring(word.length()), wordDict, map)) {
                    map.put(str, true);
                    return true;
                }
            }
        }
        map.put(str, false);
        return false;
    }
}