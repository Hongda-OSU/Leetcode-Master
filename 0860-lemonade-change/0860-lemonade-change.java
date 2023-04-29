class Solution {
    public boolean lemonadeChange(int[] bills) {
        int N = bills.length;
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for(int i=0;i<N;i++){
            if(bills[i] == 5){
                five++;
                continue;
            }
            int bill = bills[i];
            if(bill == 10){
                if(five==0){
                    return false;
                }
                ten++;
                five--;
            }else{
                if((five>=1&&ten>=1)){
                    five--;
                    ten--;
                }else if(five>=3){
                    five-=3;
                }else{
                    return false;
                }
                twenty++;
            }
        }
        return true;
    }
}