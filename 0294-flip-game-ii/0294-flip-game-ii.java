class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() == 0) return false;
        int len = s.length();
        Map<String, Boolean> memo = new HashMap<>();
        char[] ch = s.toCharArray(); 
        return dfs(ch, memo, len);
    }
    private boolean dfs(char[] ch, Map<String, Boolean> memo, int len){
        Boolean res = memo.get(String.valueOf(ch));
        if(res != null) return res;
        
        for(int i = 0; i < len-1; i++){
            if(ch[i] == '+' && ch[i+1] == '+'){
                ch[i] = '-';
                ch[i+1] = '-';
                boolean ans = dfs(ch, memo, len);
                ch[i] = '+';
                ch[i+1] = '+';
                if(!ans){
                    memo.put(String.valueOf(ch), true);
                    return true;
                }
            }
        }
        memo.put(String.valueOf(ch), false);
        return false;
    }
}