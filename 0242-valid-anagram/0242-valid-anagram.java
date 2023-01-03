class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] mapping = new int[256];
        for (int i = 0; i < s.length(); i++) {
            mapping[s.charAt(i) - 'a']++;
            mapping[t.charAt(i) - 'a']--;
        }
        for (int i : mapping) {
            if (i < 0) return false;
        }
        return true;
    }
}