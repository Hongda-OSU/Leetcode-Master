class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0, maxLeft = values[0];
        for (int j = 1; j < values.length; j++) {
            max = Math.max(max, maxLeft + values[j] - j);
            // maxLeft = values[i] + i
            maxLeft = Math.max(maxLeft, values[j] + j);
        }
        return max;
    }
}