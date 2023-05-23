class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        int n = groups.length;
        int[] cnt = new int[batchSize];
        int res = 0;
        int remgroup = 0;
        for(int i = 0; i < n; i++){
            int gr = groups[i] % batchSize;
            cnt[gr]++;
            if(gr != 0) remgroup++;
        }
        for(int i = 1; i <= batchSize / 2; i++){
            int val = Math.min(cnt[i], cnt[batchSize - i]);
            if(batchSize % 2 == 0 && i == batchSize / 2){
                val = cnt[i] / 2;
            }
            res += val;
            cnt[i] -= val;
            cnt[batchSize - i] -= val;
            remgroup -= val * 2;
        }
        res += cnt[0];
        res += dfs(0, cnt, remgroup, new HashMap<>());
        return(res);
    }
        
        
    public int dfs(int curr, int[] cnt, int remgroup, Map<String, Integer> memo){
        int n = cnt.length;
        if(remgroup == 0) return(0);
        String key = curr + Arrays.toString(cnt);
        if(memo.containsKey(key)) return(memo.get(key));
        int res = 0;
        if(curr == 0){
            res++;
            curr = n;
        }
        int val = 0;
        for(int i = 1; i < n; i++){
            //remainder of i cnt is 0
            if(cnt[i] == 0) continue;
            cnt[i]--;
            int currem = remgroup - 1;
            int nextcurr = curr - i;
            if(nextcurr < 0) nextcurr += n;
            val = Math.max(val, dfs(nextcurr, cnt, currem, memo));
            cnt[i]++;
        }
        res += val;
        memo.put(key, res);
        return(res);
    }
}