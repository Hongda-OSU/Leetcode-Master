class Solution {
    private Boolean[][] memo ;
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        String res = "";
        memo = new Boolean[len][len];
        for (int left = 0; left < len; left++){
            for (int right = left; right < len; right++){
                if (s.charAt(left) == s.charAt(right) && isPalin(s,left + 1, right -1)) {
                    if (maxLen < right - left + 1) {
                        maxLen = right - left + 1;
                        res = s.substring(left, right + 1);
                    }
                }   
            }
        }
        return res;
    }
    
    
    public boolean isPalin(String s, int left, int right){
        if (left >= right){
            return true;
        }
        if (memo[left][right] != null){
            return memo[left][right] ;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return memo[left][right] = false;
        }
        if (right - left <= 2){
            return memo[left][right] = true;
        }
        memo[left][right] = isPalin(s,left + 1, right - 1);
        return memo[left][right];
        
    }
}