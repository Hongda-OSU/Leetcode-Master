class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> memo = new HashMap<>();
        Set<String> wordsPresent = new HashSet<>();
        Collections.addAll(wordsPresent, words);
        int result = 0;
        for (String word : words) 
            result = Math.max(result, dfs(wordsPresent, memo, word));
        return result;
    }
    
    public int dfs(Set<String> words, Map<String, Integer> memo, String word) {
        if (memo.containsKey(word))
            return memo.get(word);
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if (words.contains(newWord)) {
                int currentLength = 1 + dfs(words, memo, newWord);
                maxLength = Math.max(maxLength, currentLength);
            }
            sb.insert(i, word.charAt(i));
        }
        memo.put(word, maxLength);
        return maxLength;
    }
}