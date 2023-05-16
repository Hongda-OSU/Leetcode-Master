public class ZigzagIterator {
    int i1 = 0;
    int i2 = 0;
    
    boolean flag = false;
    
    List<Integer> l1;
    List<Integer> l2;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        l1 = v1;
        l2 = v2;
    }

    public int next() {
        flag = !flag;
        
        if (i1 < l1.size() && (flag  || i2 >= l2.size())) 
            return l1.get(i1++);
            
        if (i2 < l2.size() && (!flag || i1 >= l1.size())) 
            return l2.get(i2++);
        
        return -1;
    }

    public boolean hasNext() {
        return i1 < l1.size() || i2 < l2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */