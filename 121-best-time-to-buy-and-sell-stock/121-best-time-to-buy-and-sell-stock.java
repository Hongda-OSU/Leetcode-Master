class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(0, profit += prices[i] - prices[i-1]);
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }
}