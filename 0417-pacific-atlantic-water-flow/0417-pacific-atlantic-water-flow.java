class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows= heights.length, columns = heights[0].length;
        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];
        for (int column = 0; column < columns; column++) {
            dfs(0, column, pacific, heights[0][column], heights);
            dfs(rows - 1, column, atlantic, heights[rows - 1][column], heights);
        }
        for (int row = 0; row < rows; row++) {
            dfs(row, 0, pacific, heights[row][0], heights);
            dfs(row, columns - 1, atlantic, heights[row][columns - 1], heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }
    
    public void dfs(int row, int column, boolean[][] visited, int prevHeight, int[][] heights) {
        int rows= heights.length, columns = heights[0].length;
        if (row < 0 || row >= rows || column < 0 || column >= columns || visited[row][column] || prevHeight > heights[row][column])
            return;
        visited[row][column] = true;
        dfs(row + 1, column, visited, heights[row][column], heights);
        dfs(row - 1, column, visited, heights[row][column], heights);
        dfs(row, column + 1, visited, heights[row][column], heights);
        dfs(row, column - 1, visited, heights[row][column], heights);
    }
}