class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1])
                return 0;
            return Integer.compare(a[1], b[1]);
        });
        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] point : points) {
            xStart = point[0];
            xEnd = point[1];
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }
        return arrows;
    }
}