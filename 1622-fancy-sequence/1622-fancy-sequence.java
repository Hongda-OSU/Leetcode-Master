class Fancy {
    private static final int MOD = 1_000_000_007;
    private static final int[] INV = 
        IntStream.range(0, 101).map(Fancy::modInverse).toArray();

    private static int modInverse(int a) {
        int m = MOD, y = 0, x = 1;
        while (a > 1) {
            int q = a / m;
            int t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        return x < 0 ? x + MOD : x;
    }
    
    private long mul = 1, add = 0, rmul = 1;
    private final List<Integer> list = new ArrayList<>();
    
    public Fancy() {
    }
    
    public void append(int val) {
        list.add((int)(((MOD - add + val) * rmul) % MOD));
    }
    
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % MOD;
        rmul = (rmul * INV[m]) % MOD;
        add = (add * m) % MOD;
    }
    
    public int getIndex(int idx) {
        if (idx < list.size())
            return (int)(((list.get(idx) * mul) + add) % MOD);
        else
            return -1;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */