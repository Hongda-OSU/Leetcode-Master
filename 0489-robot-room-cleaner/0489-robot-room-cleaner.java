/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public void cleanRoom(Robot robot) {
        clean(robot, 0, 0, 0, new HashSet<>());
    }
    
    public void clean(Robot robot, int x, int y, int curDirection, Set<String> visited) {
        robot.clean();
        visited.add(x + " " + y);
        for (int dir = curDirection; dir < curDirection + 4; dir++) {
            int cx = directions[dir % 4][0] + x;
            int cy = directions[dir % 4][1] + y;
            if (!visited.contains(cx + " " + cy) && robot.move())
                clean(robot, cx, cy, dir % 4, visited);
            robot.turnRight();
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}