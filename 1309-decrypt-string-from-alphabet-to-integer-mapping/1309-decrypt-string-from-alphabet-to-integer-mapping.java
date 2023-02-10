class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '#') {
                sb.append((char)('a' + (s.charAt(i - 1) - '0') + 10 * (s.charAt(i - 2) - '0') - 1)); 
                i -= 2;
            } else {
                sb.append((char)('a' + (s.charAt(i) - '0') - 1));
            }
        }
        return sb.reverse().toString();
    }
}