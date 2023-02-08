class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }
        return maxProfit;
    }
}