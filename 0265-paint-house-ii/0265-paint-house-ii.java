class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length < 1)
            return 0;
        int n = costs.length, k = costs[0].length, min = 0, iMin = 0, secondMin = 0;
        for (int i = 0; i < n; i++) {
            int m1 = Integer.MAX_VALUE, m2 = m1, iM1 = -1;
            for (int j = 0; j < k; j++) {
                int cost = costs[i][j] + (j == iMin ? secondMin : min);
                if (cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    iM1 = j;
                } else {
                    if (cost < m2)
                        m2 = cost;
                }
            }
            min = m1;
            iMin = iM1;
            secondMin = m2;
        }
        return min;
    } 
}