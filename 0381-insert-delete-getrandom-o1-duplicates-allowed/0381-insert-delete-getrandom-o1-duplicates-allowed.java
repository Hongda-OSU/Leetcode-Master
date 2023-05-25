class RandomizedCollection {
    private Map<Integer, Queue<Pair>> map;
    private List<Pair> list;
    private Random rand;
    private int size;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
        size = 0;
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) 
            map.put(val, new LinkedList<>());
        Pair p = new Pair(val, size);
        if (list.size() <= size) 
            list.add(p);
        else 
            list.set(size, p);
        size++;
        map.get(val).add(p);
        return map.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        Pair remove = map.get(val).poll();
        if (map.get(val).size() == 0)
            map.remove(val);
        Pair swap = list.get(size - 1);
        swap.pos = remove.pos;
        list.set(remove.pos, swap);
        size--;
        return true;
    }
    
    public int getRandom() {
        if (size == 0)
            return -1;
        int pos = rand.nextInt(size);
        return list.get(pos).val;
    }
}

class Pair {
    public int val, pos;
    
    public Pair(int val, int pos) {
        this.val = val;
        this.pos = pos;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */