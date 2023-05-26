class RangeModule {
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    
	/* Start with earliest interval available in the tree */
	/* And then gradually merge until there's no overlapping intervals in the tree */
    public void addRange(int left, int right) {
        if (right <= left) return;
        Map.Entry<Integer, Integer> e = map.floorEntry(left);
        
        if (e != null && e.getValue() >= left) {
            map.remove(e.getKey());
            left = e.getKey();
            right = Math.max(right, e.getValue());
        }
        
        while (true) {
            e = map.ceilingEntry(left);
            
            if (e == null || e.getKey() > right) {
                break;
            }
            
            map.remove(e.getKey());
            right = Math.max(right, e.getValue());
        }
        
        map.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> e = map.floorEntry(left);
        
        if (e == null) {
            return false;
        } else {
            return e.getKey() <= left && right <= e.getValue();
        }
    }
    
	/* Start with earliest interval available in the tree */
    public void removeRange(int left, int right) {
        if (right <= left) return;
        Map.Entry<Integer, Integer> e = map.floorEntry(left);
        
        if (e != null && e.getValue() >= left) {
            map.remove(e.getKey());
            map.put(e.getKey(), left);
            
            if (e.getValue() > right) {
                map.put(right, e.getValue());
            }
        }
        
        while (true) {
            e = map.ceilingEntry(left);
            
            if (e == null || e.getKey() > right) {
                break;
            }
            
            map.remove(e.getKey());
            
            if (e.getValue() > right) {
                map.put(right, e.getValue());
                break;
            }
        }
    }
}


/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */