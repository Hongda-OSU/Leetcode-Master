class Solution {
    private final int[][] DIRECTIONS = new int[][]
        {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.remove();
                int currX = curr[0], currY = curr[1];
                if (currX == x && currY == y)
                    return result;
                for (int[] dir : DIRECTIONS) {
                    int newX = currX + dir[0];
                    int newY = currY + dir[1];
                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        queue.add(new int[]{newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}