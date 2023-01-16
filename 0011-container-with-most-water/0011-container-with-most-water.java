class Solution {
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int width = right - left;
            max = Math.max(max, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right])
                left++;
            else 
                right--;
        }
        return max;
    }
}