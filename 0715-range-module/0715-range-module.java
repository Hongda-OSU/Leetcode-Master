class RangeModule {
    private TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Map.Entry<Integer,Integer> leftEntry = map.floorEntry(left), rightEntry = map.floorEntry(right);
        if (leftEntry != null && leftEntry.getValue() >= left)
            left = leftEntry.getKey();
        if (rightEntry != null && rightEntry.getValue() > right)
            right = rightEntry.getValue();
        map.subMap(left, right).clear();
        map.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Map.Entry<Integer,Integer> leftEntry = map.floorEntry(left);
        return leftEntry != null && leftEntry.getValue() >= right;
    }
    
    public void removeRange(int left, int right) {
        Map.Entry<Integer,Integer> leftEntry = map.floorEntry(left), rightEntry = map.floorEntry(right);
        if (leftEntry != null && leftEntry.getValue() > left)
            map.put(leftEntry.getKey(), left);
        if (rightEntry != null && rightEntry.getValue() > right)
            map.put(right, rightEntry.getValue());
        map.subMap(left, right).clear();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */