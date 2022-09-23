class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sMap = new int[256];
        Arrays.fill(sMap, -1);
        int[] tMap = new int[256];
        Arrays.fill(tMap, -1);
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i), ti = t.charAt(i);
            if (sMap[si] == -1 && tMap[ti] == -1) {
                sMap[si] = ti;
                tMap[ti] = si;
            }
            if (!(sMap[si] == ti && tMap[ti] == si)) return false;
        }
        return true;
    }
}