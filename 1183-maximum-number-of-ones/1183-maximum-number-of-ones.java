class Solution {
    public int maximumNumberOfOnes(int m, int n, int k, int max) {
        int[][] store = new int[k*k][];
        for(int i=0; i<store.length; ++i)
            store[i] = new int[] {i, 0};
        for(int i=0, x=0; i<m; ++i, x = (x == k-1 ? 0 : x+1))
            for(int j=0, y=0; j<n; ++j, y = (y == k-1 ? 0 : y+1))
                ++store[x*k + y][1];
        Arrays.sort(store, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for(int i=0; i<max; ++i)
            ans += store[i][1];
        return ans;
    }
}