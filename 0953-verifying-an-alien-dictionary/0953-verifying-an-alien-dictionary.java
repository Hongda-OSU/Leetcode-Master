class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String str1 = words[i - 1], str2 = words[i];
            int minLen = Math.min(str1.length(), str2.length());
            boolean flag = false;
            for (int j = 0; j < minLen; j++) {
                if (map[str1.charAt(j) - 'a'] < map[str2.charAt(j) - 'a']) {
                    flag = true;
                    break;
                } else if (map[str1.charAt(j) - 'a'] > map[str2.charAt(j) - 'a']) {
                    return false;
                }
            }
            if (!flag && str1.length() > str2.length())
                return false;
        }
        return true;
    } 
}