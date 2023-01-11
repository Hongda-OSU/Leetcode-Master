class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sMapping = new Stack<>();
        Stack<Character> tMapping = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#' && sMapping.size() == 0) continue;
            if (ch == '#') sMapping.remove(sMapping.size() - 1);
            else sMapping.push(ch);
        }
        for (char ch : t.toCharArray()) {
            if (ch == '#' && tMapping.size() == 0) continue;
            if (ch == '#') tMapping.remove(tMapping.size() - 1);
            else tMapping.push(ch);
        }
        return sMapping.equals(tMapping);
    }
}