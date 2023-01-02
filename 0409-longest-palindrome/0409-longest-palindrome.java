class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                set.remove(ch);
                length+=2;
            }
        }
        return set.size() > 0 ? length + 1 : length;
    }
}