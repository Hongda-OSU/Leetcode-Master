public class Solution {
    public int removeBoxes(int[] boxes) {
        List<Integer> colors = new ArrayList<>();
        List<Integer> lens = new ArrayList<>();
        // preprocessing
        // [1,1,1,3,3,2,3,3,3,1,1] would become
        // colors : [1,3,2,3,1]
        // lens :   [3,2,1,3,2]
        for (int box : boxes) {
            if (!colors.isEmpty() && colors.get(colors.size() - 1) == box) {
                // continuous, increase length count by 1
                lens.set(lens.size() - 1, lens.get(lens.size() - 1) + 1);
            } else {
                // new color
                colors.add(box);
                lens.add(1);
            }
        }
        int N = boxes.length;
        int M = colors.size();
        // dp[i][j][k] means the maximal score for colors[i:j] with k boxes of same color merged after j
        // i and j are inclusive, so dp[0][M - 1][0] will be the final answer
        int[][][] dp = new int[M][M][N];
        return dfs(colors, lens, 0, M - 1, 0, dp);
    }
    
    // top-down dfs search with memoization
    private int dfs(List<Integer> colors, List<Integer> lens, int l, int r, int k, int[][][] dp) {
        if (l > r) return 0;
        if (dp[l][r][k] > 0) return dp[l][r][k];
        // merging boxes with colors[r]
        int score = dfs(colors, lens, l, r - 1, 0, dp) + (lens.get(r) + k) * (lens.get(r) + k);
        // merge boxes with colors[l:i] and colors[l + 1:r - 1] where i from l to r - 1
        for (int i = l; i < r; i++) {
            if (colors.get(i) == colors.get(r)) {
                // notice here : since we use top-down approach, colors[i + 1:r - 1] has already been merged, so k = 0;
                // so color[i] is adjacent to color[r] now
                score = Math.max(score, 
                    dfs(colors, lens, l, i, lens.get(r) + k, dp) + dfs(colors, lens, i + 1, r - 1, 0, dp));
            }
        }
        dp[l][r][k] = score;
        return score;
    }
}