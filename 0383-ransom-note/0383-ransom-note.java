class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int j = 0; j < magazine.length(); j++) {
            char ch = magazine.charAt(j);
            if (map.containsKey(ch)) {
                int value = map.get(ch) - 1;
                if (value == 0) map.remove(ch);
                else map.put(ch, value);
            }
        }
        return map.isEmpty();
    }
}