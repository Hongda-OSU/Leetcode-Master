class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int sold = Integer.MIN_VALUE, hold = Integer.MIN_VALUE, rest = 0;
        for (int price : prices) {
            int preSold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, preSold);
        }
        return Math.max(sold, rest);
    }
}