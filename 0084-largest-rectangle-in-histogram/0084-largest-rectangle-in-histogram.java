class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int idx = i - 1;
            while (idx >= 0 && heights[idx] > heights[i]) 
                idx = lessFromLeft[idx];
            lessFromLeft[i] = idx;
        }
        for (int i = heights.length - 2; i >= 0; i--) {
            int idx = i + 1;
            while (idx < heights.length && heights[idx] >= heights[i])
                idx = lessFromRight[idx];
            lessFromRight[i] = idx;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) 
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        return maxArea;
    }
}