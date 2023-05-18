class Solution {
    public boolean canWin(String s) {
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='+'&&s.charAt(i-1)=='+' &&!canWin(s.substring(0,i-1)+"--"+s.substring(i+1,s.length())) ){
               /*自己能翻牌+敌人会输=我们赢*/
                return true;    
            }
        }    
        
        return false;
    }
}