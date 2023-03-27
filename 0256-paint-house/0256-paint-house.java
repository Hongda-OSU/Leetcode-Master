class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0)
            return 0;
        int[] previousRow = costs[costs.length - 1];
        for (int i = costs.length - 2; i >= 0; i--) {
            int[] currentRow = costs[i].clone();
            currentRow[0] += Math.min(previousRow[1], previousRow[2]);
            currentRow[1] += Math.min(previousRow[0], previousRow[2]);
            currentRow[2] += Math.min(previousRow[0], previousRow[1]);
            previousRow = currentRow;
        }
        return Math.min(Math.min(previousRow[0], previousRow[1]), previousRow[2]);
    }
}