class FirstUnique {
    private Queue<Integer> queue = new ArrayDeque<>();
    private Map<Integer, Boolean> map = new HashMap<>();

    public FirstUnique(int[] nums) {
        for (int num : nums)
            this.add(num);
    }
    
    public int showFirstUnique() {
        while (!queue.isEmpty() && !map.get(queue.peek()))
            queue.remove();
        
        if (!queue.isEmpty()) 
            return queue.peek();
        
        return -1;
    }
    
    public void add(int value) {
        if (!map.containsKey(value)) {
            map.put(value, true);
            queue.add(value);
        } else {
            map.put(value, false);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */