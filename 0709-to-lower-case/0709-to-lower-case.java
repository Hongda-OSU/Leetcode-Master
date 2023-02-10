class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch > 64 && ch < 91 ? (char)(ch + 32) : ch);
        }
        return sb.toString();
    }
}