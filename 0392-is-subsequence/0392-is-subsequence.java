class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int p = 0;
        for (int i = 0; i < t.length(); i++) {
            char c1 = s.charAt(p);
            char c2 = t.charAt(i);
            if (c1 == c2) {
                p++;
            }
            if (p == s.length()) {
                return true;
            }
        }
        return false;
    }
}