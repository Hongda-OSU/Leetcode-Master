class Solution {
    public int maxProfit(int[] prices, int fee) {
        int m = prices.length, buy = 0, sell = -prices[0];
        for (int i = 1; i < m; i++) {
            buy = Math.max(buy, sell + prices[i] - fee);
            sell = Math.max(sell, buy - prices[i]);
        }
        return buy;
    }
}