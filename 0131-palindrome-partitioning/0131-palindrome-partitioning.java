class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, list, result);
        return result;
    }
    
    public void dfs(String str, int pos, List<String> list, List<List<String>> result) {
        if (pos == str.length()) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = pos; i < str.length(); i++) {
                if (isPalindrome(str, pos, i)) {
                    list.add(str.substring(pos, i + 1));
                    dfs(str, i + 1, list, result);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    
    public boolean isPalindrome(String str, int low, int high) {
        while (low < high) {
            if (str.charAt(low++) != str.charAt(high--))
                return false;
        }
        return true;
    }
}