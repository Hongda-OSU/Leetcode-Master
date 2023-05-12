class Solution {
    final int max = 1000000007;
    Long[][] mem = null;
    public int numWays(int steps, int arrLen) {
        mem = new Long[steps+1][2*steps+1];
        return (int)dfs(steps, 0, arrLen)%max;
    }
    
    long dfs(int steps, int arrLen, int farrLen) {
        if (arrLen >= farrLen || arrLen < 0 || steps < 0) return 0;
        if (steps == 0 && arrLen == 0) { return 1;}
        if (mem[steps][arrLen] != null) return mem[steps][arrLen];
        
        long c = dfs(steps-1, arrLen+1, farrLen)%max + dfs(steps-1, arrLen, farrLen)%max + dfs(steps-1, arrLen-1, farrLen)%max;
        c = c%max;
        mem[steps][arrLen] = c;
        return c;
        
    }
}