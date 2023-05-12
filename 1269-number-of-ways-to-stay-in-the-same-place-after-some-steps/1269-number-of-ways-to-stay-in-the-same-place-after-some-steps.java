class Solution {
    
    public int numWays(int steps, int arrLen) {
        int[][] memo = new int[steps + 1][steps + 1];
        return helper(steps , arrLen , 0 , memo );
    }
    
    private int helper(int moves , int N , int i , int[][]memo){
        
        if(i  > moves){
            return 0 ;
         }
        
        if(moves == 0 && i == 0){
            return 1;
        }
        
        if(memo[moves][i] != 0){
            return memo[moves][i];
        }
        
        int res = 0 , MOD = 1_000_000_007;
        
        res = helper(moves - 1  , N , i , memo) % MOD; 
        
        if(i > 0){
            res = ( res % MOD + helper(moves - 1 , N , i - 1 , memo) % MOD ) % MOD;
        }
        if( i < N - 1){
            res = ( res % MOD +  helper(moves - 1 , N ,  i + 1 , memo) % MOD ) % MOD;
        }
        
        memo[moves][i] = res;
        
      return res;  
        
    }
    
    
}