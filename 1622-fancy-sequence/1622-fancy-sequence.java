class Fancy {
    private static final int MOD = 1_000_000_007;
    private List<Position> list = new ArrayList<>();
    
    public Fancy() {
        list.add(new Position(0));
    }
    
    public void append(int val) {
        list.add(new Position(val));
    }
    
    public void addAll(int inc) {
        add(list.size() - 1, inc);
    }
    
    public void multAll(int m) {
        mult(list.size() - 1, m);
    }
    
    public int getIndex(int idx) {
        if (idx > list.size() - 2)
            return -1;
        
        return query(idx);
    }
    
    private int query(int i) {
        i++;

        long val = list.get(i).val;
        
        while (i < list.size()) {
            Position p = list.get(i);
            val = (val * p.mult) % MOD;
            val = (val + p.add) % MOD;
            
            i += i & -i;
        }

        return (int) val;
    }
    
    private void add(int i, long val) {
        while (i > 0) {
            Position p = list.get(i);
            p.add = (int) ((p.add + val) % MOD);

            i -= i & -i;
        }
    }
    
    private void mult(int i, long val) {
        while (i > 0) {
            Position p = list.get(i);
            p.add = (int) ((val * p.add) % MOD);
            p.mult = (int) ((val * p.mult) % MOD);
            i -= i & -i;
        }
    }
    
    class Position {
        int val;
        int mult = 1;
        int add = 0;
        
        Position(int val) {
            this.val = val;
        }
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