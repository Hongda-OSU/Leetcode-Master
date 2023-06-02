class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] memo = new int[m][n];
        helper(0, 0, dungeon, memo);
        return memo[0][0];
    }
    
    private int helper(int i, int j, int[][] dungeon, int[][] memo) {
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1)
            return memo[i][j] = dungeon[i][j] <= 0 ? 1 - dungeon[i][j] : 1;
        if (i >= dungeon.length || j >= dungeon[0].length)
            return Integer.MAX_VALUE;
        if (memo[i][j] != 0)
            return memo[i][j];
        int result = Math.min(helper(i + 1, j, dungeon, memo), helper(i, j + 1, dungeon, memo)) - dungeon[i][j];
        return memo[i][j] = result <= 0 ? 1 : result;
    }
}