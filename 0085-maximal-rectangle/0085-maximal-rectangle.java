class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix[0].length, max = 0;
        int[] heights = new int[m];
        for (char[] row : matrix) {
            for (int i = 0; i < m; i++) {
                if (row[i] == '1')
                    heights[i] += 1;
                else
                    heights[i] = 0;
            }
            max = Math.max(max, maxArea(heights));
        }
        return max;
    }
    
    public int maxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int idx = stack.pop();
                int leftBound = -1;
                if (!stack.isEmpty()) 
                    leftBound = stack.peek();
                max = Math.max(max, heights[idx] * (i - leftBound - 1));
            }
            stack.push(i);
        }
        return max;
    }
}