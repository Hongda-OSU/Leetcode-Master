class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] health = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    health[i][j] = Math.max(1, 1 - dungeon[i][j]);
                else if (i == m - 1) 
                    health[i][j] = Math.max(1, health[i][j + 1] - dungeon[i][j]);
                else if (j == n - 1)
                    health[i][j] = Math.max(1, health[i + 1][j] - dungeon[i][j]);
                else
                    health[i][j] = Math.max(1, Math.min(health[i + 1][j], health[i][j + 1]) - dungeon[i][j]);
            }
        }
        return health[0][0];
    }
}