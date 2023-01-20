class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //initialization for 8 directions, a map(map is the name, it is a Queue for BFS) and row-column boundaries
        int[][] dirs = new int[][] {{1,1},{1,0},{0,1},{1,-1},{-1,1},{-1,0},{0,-1},{-1,-1}};
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length, columns = grid[0].length;
        //if start point is blocked, return -1, otherwise give map the start point
        if (grid[0][0] == 1) return -1; 
        //first two parameters are coordinates, third keep track of the distance
        queue.offer(new int[] {0, 0, 1});
        while (!queue.isEmpty()) {
            //get current coordinates and distance travelled
            int[] location = queue.poll();
            int row = location[0];
            int column = location[1];
            int distance = location[2];
            //return if reaches the destination
            if (row == rows - 1 && column == columns - 1) return distance;
            for (int[] dir : dirs) {
                int row2 = row + dir[0];
                int column2 = column + dir[1];
                if (row2 < rows && row2 >= 0 && column2 < columns && column2 >= 0 && grid[row2][column2] == 0) {
                    //add unexplored point to map and increment distance by 1
                    queue.offer(new int[] {row2, column2, distance + 1});
                    //set this point to 1 as explored
                    grid[row2][column2] = 1;
                }
            }
        }
        // whole space searched, cannot reach destination
        return - 1;
    }
}