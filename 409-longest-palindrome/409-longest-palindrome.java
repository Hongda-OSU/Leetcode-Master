class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        HashSet<Character> hs = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (hs.contains(c)) {
                hs.remove(c);
                res++;
            } else {
                hs.add(c);
            }
        }
        return hs.isEmpty() ? 2 * res : 2* res + 1;
    }
}