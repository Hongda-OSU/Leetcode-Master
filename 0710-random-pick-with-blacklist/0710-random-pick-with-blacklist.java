class Solution {
    public Map<Integer, Integer> map;
    public Random rnd;
    public int m;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        for (int b : blacklist)
            map.put(b, -1);
        m = n - map.size();
        for (int b : blacklist) {
            if (b < m) {
                while (map.containsKey(n - 1))
                    n--;
                map.put(b, n - 1);
                n--;
            }
        }
        rnd = new Random();
    }
    
    public int pick() {
        int p = rnd.nextInt(m);
        if (map.containsKey(p))
            return map.get(p);
        return p;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */