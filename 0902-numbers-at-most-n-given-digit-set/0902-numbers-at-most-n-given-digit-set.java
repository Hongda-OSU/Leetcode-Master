class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String strNum=Integer.toString(n);  //Converted n to String for finding no. of digits in it.
        int nDigitCount=strNum.length();    
        
        int digitsLen=digits.length;    //length of digits array
        int res=0;  //result variable
        
        //loop for finding count of numbers having no. of digits 1 less than no. of digits in n 
        for(int i=1;i<nDigitCount;i++){   //here i means no. of digits considered for making number
            res+=(int)Math.pow(digitsLen,i);    //formula related to permutation & combination
        }
        
        boolean breakFlag=false;   
        
        //flag to check if got a number equal to that place number,so that we can further traverse by keeping earlier place fixed.
        boolean equalFlag=false;
        
        for(int i=0;i<nDigitCount;i++){ //i is pointer to digits in n.
            equalFlag=false;
            //we traverse from end,since array s sorted. So if we got less than current digit in n then all the combination below that position will be less than n
            for(int j=digitsLen-1;j>=0;j--){  //j is pointer to traverse in digits array
                if(Integer.parseInt(digits[j])<strNum.charAt(i)-'0'){   
                    //(j+1) for current position and remaining formula for remaining positions
                    res+=(j+1)*((int)Math.pow(digitsLen,nDigitCount-i-1));
                    break;
                }
                else if(Integer.parseInt(digits[j])==strNum.charAt(i)-'0') 
                    equalFlag=true;
                else if(j==0) //if we went until 0th digit then we haven't got a digit to satisfy our condition
                    breakFlag=true;
            }
            if(!equalFlag || breakFlag)
                break;
        }
        if(equalFlag)   //this is to add the exact number n. For eg. if n=55 and digits=["2","5"],above loop won't add to res for 55.
            res++;
        return res;
    }
}