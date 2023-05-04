class Solution {
    public int digitsCount(int d, int low, int high) {
        return countDigit(high, d) - countDigit(low-1, d);
    }
    
    int countDigit(int n, int d) {
        if(n < 0 || n < d) {
            return 0;
        }
        
        int count = 0;
        for(long i = 1; i <= n; i*= 10) {
            long divider = i * 10;
            count += (n / divider) * i;
            
            if (d > 0) {
                count += Math.min(Math.max(n % divider - d * i + 1, 0), i); // comment1: tailing number need to be large than d *  i to qualify.
            } else {
                if(n / divider > 0) {
                    if(i > 1) {  // comment2: when d == 0, we need avoid to take numbers like 0xxxx into account.
                        count -= i;
                        count += Math.min(n % divider + 1, i);  
                    }
                }
            }
        }
        
        return count;
    }
}