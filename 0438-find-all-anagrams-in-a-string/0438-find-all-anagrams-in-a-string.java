class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> result = new ArrayList<Integer>();
        if (pLen > sLen) return result;
        int[] sMapping = new int[26];
        int[] pMapping = new int[26];
        for (int i = 0; i < pLen; i++) {
            pMapping[p.charAt(i) - 'a']++;
        }
        for (int j = 0; j < sLen; j++) {
            sMapping[s.charAt(j) - 'a']++;
            if (j >= pLen) 
                sMapping[s.charAt(j - pLen) - 'a']--;
            if (Arrays.equals(sMapping, pMapping))
                result.add(j - pLen + 1);
        }
        return result;
    }
}