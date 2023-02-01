class Solution {
    public int maxPoints(int[][] points) {
        int result = 0;
        for (int[] point1 : points) {
            HashMap<Double, Integer> map = new HashMap<>();
            for (int[] point2 : points) {
                if (point1 == point2) continue;
                double slope = 0;
                // if x2 - x1 are equal then line is vertical
                if (point1[0] == point2[0])
                    slope=Double.POSITIVE_INFINITY; 
                // slope (m) = (y2 - y1) / (x2 - x1) 
                else
                    slope = (point2[1] - point1[1]) / (double)(point2[0] - point1[0]);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                if (map.get(slope) > result)
                    result = map.get(slope);
            }
        }
        // add the first point back
        return result + 1;
    }
}