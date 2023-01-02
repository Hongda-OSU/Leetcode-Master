class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int length = 0;
        for (char ch : s.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                set.remove(ch);
                length++;
            }
        }
        return set.isEmpty() ? 2 * length : 2 * length + 1;
    }
}