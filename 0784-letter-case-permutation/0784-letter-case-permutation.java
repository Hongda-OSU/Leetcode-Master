class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, new StringBuilder());
        return result;
    }
    
    public void backtrack(List<String> result, String s, int index, StringBuilder sb) {
        if (index == s.length()) {
            result.add(new String(sb));
            return;
        }
        char ch = s.charAt(index);
        if (Character.isDigit(ch)) {
            sb.append(ch);
            backtrack(result, s, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(Character.toLowerCase(ch));
            backtrack(result, s, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toUpperCase(ch));
            backtrack(result, s, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}