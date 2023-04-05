class Solution {
    
    Boolean[][] memo ;
    
    public String longestPalindrome(String s) {
        
        int len = s.length();
        
        int maxLen = 0;
        String res = "";
        memo = new Boolean[len][len];
        
        for (int left = 0; left < len; left++){
            for (int right = left; right < len; right++){
                
             if (s.charAt(left) == s.charAt(right) && isPalin(s,left + 1, right -1)){
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
            memo[left][right] = false;
            return memo[left][right];
        }
        
        if (right - left <= 2){
            memo[left][right] = true;
            return memo[left][right];
        }
        
        memo[left][right] = isPalin(s,left + 1, right - 1);
        return memo[left][right];
        
    }
    
}