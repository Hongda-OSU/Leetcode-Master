class RangeModule {
    TreeMap<Integer, Integer> m = new TreeMap<>();
    public RangeModule() {}
    
    public void addRange(int s, int e) { // s: start, e: end
        // find overlap ranges, calc merged range, clear overlapped ranges, insert merged range
        var L = m.floorEntry(s); // left possible overlap entry
        var R = m.floorEntry(e); // right possible overlap entry

        if (L != null && L.getValue() >= s) s = L.getKey(); // update overlap start
        if (R != null && R.getValue() > e) e = R.getValue(); // update overlap end

        m.subMap(s, e).clear(); // clear all overlapped entries
        m.put(s, e); // save final merged entry
    }
    
    public boolean queryRange(int s, int e) {
        var L = m.floorEntry(s);
        return L != null && L.getValue() >= e; // if there exist a range: start <+ s, end >= e
    }
    
    public void removeRange(int s, int e) {
        var L = m.floorEntry(s); // left possible overlap entry
        var R = m.floorEntry(e); // right possible overlap entry

        if (L != null && L.getValue() > s) m.put(L.getKey(), s); // after removal, if anything left
        if (R != null && R.getValue() > e) m.put(e, R.getValue()); // after removal, if anything left

        m.subMap(s, e).clear(); // removal
    }
}
/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */