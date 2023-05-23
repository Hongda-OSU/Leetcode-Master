class Solution {
    
    HashMap<Long, Integer> map = new HashMap<>();
    
    class State {
        long mask = 0;
        
        State(long v) {
            mask = v;
        }
        
        public boolean isEmpty(int i) {
            return ((mask >> (i*5)) & 31L) == 0;
        }
        
        public void add(int i, long v) {
            mask += v << (i*5);
        }
        
        public void minus1(int i) {
            mask -= 1L << (i*5);
        }
    }
    
    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] cnt = new int[batchSize];
        for (int g : groups) {
            cnt[g % batchSize]++;
        }
        
        // optimization
        // try to combine groups to pairs
        for (int i = 1; i < batchSize; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            
            int search = batchSize - i;
            
            if (search == i) {
                cnt[0] += cnt[i] / 2;
                cnt[i] = cnt[i] % 2;
                continue;
            }
            
            int min = Math.min(cnt[i], cnt[search]);
            cnt[0] += min;
            cnt[i] -= min;
            cnt[search] -= min;
        }
        
        State state = new State(0);
        for (int i = 1; i < batchSize; i++) {
            state.add(i, cnt[i]);
        }
        
        return dfs(0, batchSize, state) + cnt[0];
    }
    
    public int dfs(int rem, int batchSize, State state) {
        if (state.mask == 0) {
            return 0;
        }
        if (map.containsKey(state.mask)) {
            return map.get(state.mask);
        }
        
        int max = 0;
        
        for (int i = 1; i < batchSize; i++) {
            if (state.isEmpty(i)) {
                continue;
            }
            State newState = new State(state.mask);
            newState.minus1(i);
            max = Math.max(max, dfs((batchSize-i+rem)%batchSize, batchSize, newState));
        }
        
        max += (rem == 0) ? 1 : 0;
        
        map.put(state.mask, max);
        
        return max;
    }
}