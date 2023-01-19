class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map_char = new HashMap<>();
        HashMap<String, Character> map_word = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        for (int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            // if we don't have ch, then we shouldn't have word
            if (!map_char.containsKey(ch)) {
                if (map_word.containsKey(word)) {
                    return false;
                } else {
                    map_char.put(ch, word);
                    map_word.put(word, ch);
                }
            } else {
                String word_mapped = map_char.get(ch);
                if (!word_mapped.equals(word))
                    return false;
            }
        }
        return true;
    }
}