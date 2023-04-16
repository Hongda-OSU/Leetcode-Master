class Solution {
 public int maxProfit(int k, int[] prices) {
        
        if(k == 0 || prices.length < 2)
            return 0;
        
        // All k transactions will be stored in an array where index 0 will represent the minimum cost
        // of the transaction and index 1 will represent the maximum profit of that transaction.
        // The first transaction will be built on the idea that 0 transactions have occured before it
        // and the kth transaction will have had k - 1 transactions already occur. The profits from 
        // earlier transactions will affect the total profit of the later transactions, with the kth 
        // transaction experiencing the largest effect. 
        int[][] transactions = new int[k][2];
        
        // Since we are continuously searching for the minumum cost, initalize the cost of each transaction to 
        // be the int max value, the first price will be lower and overwrite this. 
        for(int i = 0; i < k; i++)
            transactions[i][0] = Integer.MAX_VALUE;
        
        for(int price : prices){
            
            // Check the minumum cost and maximum profit possible for all k transactions.
            for(int i = 0; i < k; i++){
                
                // This is the critical concept here, we understand that the profits from an earlier 
                // transaction will actually lower the total cost of the current transaction. If we are on
                // the first transaction however, there are no previous transaction profits that could lower
                // the minumum price of the current transaction. This concept builds cumulatively which 
                // means that the kth transaction will have the lowest possible cost which also means it
                // will have the hightest possible profit.
                int prevProfit = 0;
                
                // Only set the value of the previous transactions profit if we have moved past the first
                // transaction.
                if(i > 0)
                    prevProfit = transactions[i - 1][1];
                
                // set the current cost of the current transaction, if this is not the first transaction, 
                // then the profit of the previous transaction will lower the current price.
                transactions[i][0] = Math.min(transactions[i][0], price - prevProfit);
                
                // given the current lowest possible seen price, check if the current price if 
                // sold produces the maximum possible profit from this transaction.
                transactions[i][1] = Math.max(transactions[i][1], price - transactions[i][0]);
            }
        }
        
        // The kth transaction has the maximum possible profit.
        return transactions[k - 1][1];
    }
}