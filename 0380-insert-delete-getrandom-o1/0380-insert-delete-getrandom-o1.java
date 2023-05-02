class RandomizedSet {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] arr = new int[100001];
    private int index = 0;
    private Random rnd = new Random();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        arr[index] = val;
        map.put(val, index);
        index++;
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int pos = map.remove(val);
        arr[pos] = arr[index - 1];
        if (map.containsKey(arr[index - 1]))
            map.put(arr[index - 1], pos);
        index--;
        return true;
    }
    
    public int getRandom() {
        return arr[rnd.nextInt(index)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */