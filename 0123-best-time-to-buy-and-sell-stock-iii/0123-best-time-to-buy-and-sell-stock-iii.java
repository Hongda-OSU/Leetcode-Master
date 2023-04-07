class Solution {
    public int maxProfit(int[] prices) {
        int buyOne = Integer.MAX_VALUE, sellOne = 0, buyTwo = Integer.MAX_VALUE, sellTwo = 0;
        for (int price : prices) {
            buyOne = Math.min(buyOne, price);
            sellOne = Math.max(sellOne, price - buyOne);
            buyTwo = Math.min(buyTwo, price - sellOne);
            sellTwo = Math.max(sellTwo, price - buyTwo);
        }
        return sellTwo;
    }
}