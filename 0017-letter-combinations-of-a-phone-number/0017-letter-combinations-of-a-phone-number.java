class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // 0, 1, 2...
        String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        if (digits.length() == 0) return result;
        backtrack(result, digits, "", dict);
        return result;
    } 
    
    public void backtrack(List<String> result, String digits, String str, String[] dict) {
        if (str.length() == digits.length()) {
            result.add(str);
            return;
        }
        int i = str.length();
        int digit = digits.charAt(i) - '0';
        for (char letter : dict[digit].toCharArray()) {
            backtrack(result, digits, str + Character.toString(letter), dict);
        }
    }
}