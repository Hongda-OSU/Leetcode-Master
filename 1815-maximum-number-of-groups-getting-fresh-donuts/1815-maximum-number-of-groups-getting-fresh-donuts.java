class Solution {
    private HashMap<Long, Integer> map = new HashMap<>();
    
    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] count = new int[batchSize];
        for (int group : groups) 
            count[group % batchSize]++;
        for (int i = 1; i < batchSize; i++) {
            if (count[i] == 0)
                continue;
            int search = batchSize - i;
            if (search == i) {
                count[0] += count[i] / 2;
                count[i] = count[i] % 2;
                continue;
            }
            int min = Math.min(count[i], count[search]);
            count[0] += min;
            count[i] -= min;
            count[search] -= min;
        }
        State state = new State(0);
        for (int i = 1; i < batchSize; i++) 
            state.add(i, count[i]);
        return dfs(0, batchSize, state) + count[0];
    }
    
    private int dfs(int num, int batchSize, State state) {
        if (state.mask == 0)
            return 0;
        if (map.containsKey(state.mask))
            return map.get(state.mask);
        int max = 0;
        for (int i = 1; i < batchSize; i++) {
            if (state.isEmpty(i))
                continue;
            State newState = new State(state.mask);
            newState.minus(i);
            max = Math.max(max, dfs((batchSize - i + num) % batchSize, batchSize, newState));
        }
        max += (num == 0) ? 1 : 0;
        map.put(state.mask, max);
        return max;
    }
}

class State {
    public long mask;
    
    public State(long mask) {
        this.mask = mask;
    }
    
    public boolean isEmpty(int i) {
        return ((mask >> (i * 5)) & 31L) == 0;
    } 
    
    public void add(int i, long v) {
        mask += v << (i * 5);
    }
    
    public void minus(int i) {
        mask -= 1L << (i * 5);
    }
}