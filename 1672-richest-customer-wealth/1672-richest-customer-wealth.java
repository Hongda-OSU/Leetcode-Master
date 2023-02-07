class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] account : accounts) {
            int currWealth = 0;
            for (int money : account) {
                currWealth += money;
            }
            maxWealth = Math.max(maxWealth, currWealth);
        }
        return maxWealth;
    }
}