class Solution {
    private Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    private Map<Character, Boolean> visited = new HashMap<>();
    private StringBuilder sb = new StringBuilder();
    
    public String alienOrder(String[] words) {
        for (String word : words) {
            for (char ch : word.toCharArray())
                reverseAdjList.putIfAbsent(ch, new ArrayList<>());
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        for (Character ch : reverseAdjList.keySet()) {
            boolean result = dfs(ch);
            if (!result)
                return "";
        }
        return sb.toString();
    }
    
    public boolean dfs(Character ch) {
        if (visited.containsKey(ch))
            return visited.get(ch);
        visited.put(ch, false);
        for (Character next : reverseAdjList.get(ch)) {
            boolean result = dfs(next);
            if (!result)
                return false;
        }
        visited.put(ch, true);
        sb.append(ch);
        return true;
    }
}