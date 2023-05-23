class Solution {
    Map<String, Integer> dp = new HashMap<>();
    int len;
    public int maxScore(int[] nums) {
        len = nums.length;
        char[] mask = new char[len];
        for (int i = 0; i < len; i++) mask[i] = '0';
        return dfs(mask, 0, nums);
    }

    private int dfs(char[] mask, int multi, int[] nums) {
        String key = new String(mask);
        if (dp.containsKey(key)) return dp.get(key);
        if (multi * 2 == len) return 0; // you picked all nums;
        int res = 0;
        List<Integer> unVisited = getZeros(mask);
        for (int i = 0; i < unVisited.size() - 1; i++) {
            for (int j = i + 1; j < unVisited.size(); j++) {
                int a = unVisited.get(i), b = unVisited.get(j);
                char[] newMask = mask.clone();
                newMask[a] = '1';
                newMask[b] = '1';
                res = Math.max(res, dfs(newMask, multi + 1, nums) + gcd(nums[a], nums[b]) * (multi + 1));
            }
        }
        dp.put(key, res);
        return res;
    }

    private List<Integer> getZeros(char[] msk) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (msk[i] == '0') list.add(i);
        }
        return list;
    }

    private int gcd(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcd(b, a - b);
        return gcd(a, b - a);
    }
}