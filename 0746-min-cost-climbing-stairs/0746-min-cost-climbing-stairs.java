class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // p1 records move 1 step, p2 records move 2 step
        // p1 change to better cost by comparing p1 and p2
        int p1 = 0, p2 = 0, len = cost.length;
        for (int i = 2; i < len + 1; i++) {
            int temp = p1;
            p1 = Math.min(p1 + cost[i-1], p2 + cost[i-2]);
            p2 = temp;
        }
        return p1;
    }
}