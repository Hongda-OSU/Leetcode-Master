class Solution {
    public int longestPalindrome(String s) {
       int[] count = new int[256];
        for (char ch : s.toCharArray())
            count[ch]++;
        boolean bool = false;
        int len = 0;
        for (int c : count) {
            if (c % 2 == 0)
                len += c;
            else {
                len += c - 1;
                bool = true;
            }
        }
        return bool ? len + 1 : len;
    }
}