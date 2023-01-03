class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int windowSize = s1.length();
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for (int i = 0; i < windowSize; i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        for (int j = 0; j < s2.length() - windowSize; j++) {
            if (match(s1Map, s2Map)) return true;
            s2Map[s2.charAt(j + windowSize) - 'a']++;
            s2Map[s2.charAt(j) - 'a']--;
        }
        return match(s1Map, s2Map);
    }
    
    public boolean match(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) return false;
        }
        return true;
    }
}