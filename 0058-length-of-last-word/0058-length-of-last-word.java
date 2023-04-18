class Solution {
    public int lengthOfLastWord(String s) {
        int p = s.length(), len = 0;
        while (p > 0) {
            p--;
            if (s.charAt(p) != ' ')
                len++;
            else if (len > 0)
                return len;
        }
        return len;
    }
}