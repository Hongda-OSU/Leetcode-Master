class Solution {
    public int removeBoxes(int[] boxes) {
        int [][][] dp = new int [boxes.length][boxes.length][boxes.length];
        return dfs(boxes, 0, boxes.length -1, 0, dp);
    }
    private int dfs(int [] boxes, int start, int end, int prefix, int [][][] dp){
        int res = 0;
        int count = 0;
        if(start > end)
            return 0;
        if(start == end)
            return (prefix+1)*(prefix+1);
        if(dp[start][end][prefix] != 0)
            return dp[start][end][prefix];
        int index = start;
        while(index <= end && boxes[index] == boxes[start]){
            index++;
            count++;
        }
        int newStart = index;
        res = (count+prefix)* (count+ prefix) + dfs(boxes, newStart, end, 0, dp);
        while(index <= end){
            if(boxes[index] == boxes[start] && boxes[index-1] != boxes[start]){
                res = Math.max(res, dfs(boxes, newStart, index-1, 0, dp) + dfs(boxes, index, end, count+prefix, dp));
            }
            index++;
        }
        dp[start][end][prefix] = res;
        return res; 
    }
}