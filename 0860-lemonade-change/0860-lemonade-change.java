class Solution {
    public boolean lemonadeChange(int[] bills) {
         int num5 = 0;
        int num10 = 0;
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                num5++;
            }else if(bills[i] == 10){
                if(num5 == 0){
                    return false;
                }
                num5 --;
                num10++;
            }else{
                if(num10 == 0){
                    if(num5 < 3){
                        return false;
                    }else{
                        num5 -= 3;
                    }
                }else if(num10 != 0){
                    if(num5 == 0){
                        return false;
                    }else{
                        num5 --;
                        num10 --;
                    }
                }
            }
        }
        return true;
    }
}