
class RandomizedCollection {

    class Pair {
        int val;
        int pos;
        public Pair (int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }
    
    Map<Integer, Queue<Pair>> map;
    List<Pair> lists;
    Random rand;
    int size;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.lists = new ArrayList<>();
        this.size = 0;
        this.rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, new LinkedList<>());
        }
        
        Pair p = new Pair(val, this.size);
        
        if(lists.size() <= this.size) {
            lists.add(p);
        } else {
            lists.set(size, p);
        }
        this.size++;
        map.get(val).add(p);
        
        return map.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(! map.containsKey(val)) {
            return false;
        }
        
        Pair toRemove = this.map.get(val).poll();
        
        if (this.map.get(val).size() == 0) {
            map.remove(val);
        }
        
        Pair swapped = this.lists.get(this.size-1);
        swapped.pos = toRemove.pos;
        lists.set(toRemove.pos, swapped);
        this.size--;
        return true;
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if(size == 0) return -1;
        int pos = rand.nextInt(size);
        return lists.get(pos).val;        
    }
}


/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */