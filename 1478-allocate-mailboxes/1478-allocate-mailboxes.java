class Solution {
    private Integer[][] cache;
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        cache = new Integer[houses.length+1][k+1];
        int res = dfs(houses, 0, k);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int dfs(int[] houses, int idx, int k){
        if(k == 0 || idx >= houses.length) return Integer.MAX_VALUE;
        if(cache[idx][k]!=null) return cache[idx][k];
        if(k == 1){
            return getMedianSum(houses, idx, houses.length - 1);
        }
        int min = Integer.MAX_VALUE;
        for(int i=idx; i<houses.length-k+1; i++){
            //next group
            int m1 = getMedianSum(houses, idx, i);
            int d1 = dfs(houses, i+1, k - 1);
            if(m1 != Integer.MAX_VALUE && d1 != Integer.MAX_VALUE){
                min = Math.min(min, m1 + d1);
            }
        }
        cache[idx][k] = min;
        return min;
    }
    private int getMedianSum(int houses[], int l, int r) { 
        int m = houses[l + (r-l)/2];
        int sum = 0;
        for(int i=l;i<=r;i++){
            sum += Math.abs(houses[i] - m);
        }
        return sum;
    } 
}