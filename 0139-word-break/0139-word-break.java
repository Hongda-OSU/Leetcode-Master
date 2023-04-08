class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> set = new HashSet<>();
        return dfs(s, 0, wordDict, set);
    }
    
    public boolean dfs(String s, int idx, List<String> dict, Set<Integer> set) {
        if (idx == s.length())
            return true;
        if (set.contains(idx))
            return false;
        for (int i = idx + 1; i <= s.length(); i++) {
            String str = s.substring(idx, i);
            if (dict.contains(str)) 
                if (dfs(s, i, dict, set))
                    return true;
                else 
                    set.add(i);
        }
        set.add(idx);
        return false;
    }
}
