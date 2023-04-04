class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extractPalindrome(s, i, i);
            count += extractPalindrome(s, i, i + 1);
        }
        return count;
    }
    
    public int extractPalindrome(String str, int left, int right) {
        int count = 0;
        while (left >= 0 && right < str.length() && (str.charAt(left) == str.charAt(right))) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}