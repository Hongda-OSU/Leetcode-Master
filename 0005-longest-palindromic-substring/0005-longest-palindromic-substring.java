class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int left = i, right = i;
            while (left >= 0 && s.charAt(left) == ch) 
                left--;
            while (right < s.length() && s.charAt(right) == ch)
                right++;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                left--;
                right++;
            }
            left += 1;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }
        return s.substring(start, end);
    }
}