class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0, sold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // sold - fee + prices[i] => should i sold at day ith to make profit
            profit = Math.max(profit, sold - fee + prices[i]);
            sold = Math.max(sold, profit - prices[i]);
        }
        return profit;
    }
}