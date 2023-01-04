class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        if (color != target) dfs(image, sr, sc, color, target);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int color, int target) {
        if (image[sr][sc] == target) {
            image[sr][sc] = color;
            if (sr - 1 >= 0) dfs(image, sr - 1, sc, color, target);
            if (sc - 1 >= 0) dfs(image, sr, sc - 1, color, target);
            if (sr + 1 < image.length) dfs(image, sr + 1, sc, color, target);
            if (sc + 1 < image[0].length) dfs(image, sr, sc + 1, color, target);
        }
    }
}