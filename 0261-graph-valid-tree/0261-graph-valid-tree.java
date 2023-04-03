class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if (x == y)
                return false;
            nums[x] = y;
        }
        return edges.length == n - 1;
    }
    
    public int find(int[] parent, int x) {
        if (parent[x] == -1) 
            return x;
        return find(parent, parent[x]);
    } 
}