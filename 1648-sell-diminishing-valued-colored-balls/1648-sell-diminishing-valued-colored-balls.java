class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int mod = 1_000_000_007;
        Arrays.sort(inventory);
        int curIndex = inventory.length - 1;
        int curValue = inventory[curIndex];
        long profit = 0;
        while (orders > 0) {
            while (curIndex >= 0 && inventory[curIndex] == curValue) 
                curIndex--;
            int nextValue = curIndex < 0 ? 0 : inventory[curIndex];
            int numSameColor = inventory.length - curIndex - 1;
            long nums = (long) (curValue - nextValue) * numSameColor;
            if (orders >= nums) {
                profit += (long)(curValue + nextValue + 1) * (curValue - nextValue) / 2 * numSameColor;
            } else {
                int numFullRow = orders / numSameColor;
                int remainder = orders % numSameColor;
                profit += (long)(curValue + curValue - numFullRow + 1) * numFullRow / 2 * numSameColor;
                profit += (long)(curValue - numFullRow) * remainder;
            }
            orders -= nums;
            profit = profit % mod;
            curValue = nextValue;
        }
        return (int)profit;
    }
}