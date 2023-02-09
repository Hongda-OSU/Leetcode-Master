class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length(), p1 = 0, p2 = 0, p = 0;
        char[] result = new char[l1 + l2];
        while (p1 < l1 || p2 < l2) {
            if (p1 < l1) 
                result[p++] = word1.charAt(p1++);
            if (p2 < l2)
                result[p++] = word2.charAt(p2++);
        }
        return new String(result);
    }
}