class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int result = 1;
        for (int coin : coins) {
            if (coin > result)
                break;
            result += coin;
        }
        return result;
    }
}