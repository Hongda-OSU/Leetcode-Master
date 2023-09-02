class Solution {
    public int countLetters(String S) {
        int total = 0;
        for (int left = 0, right = 0; right <= S.length(); right++) {
            if (right == S.length() || S.charAt(left) != S.charAt(right)) {
                int lenSubstring = right - left;
                // more details about the sum of the arithmetic sequence:
                // https://en.wikipedia.org/wiki/Arithmetic_progression#Sum
                total += (1 + lenSubstring) * lenSubstring / 2;
                left = right;
            }
        }
        return total;
    }
}