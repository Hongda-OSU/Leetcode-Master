class FirstUnique {
  
  private Set<Integer> setQueue = new LinkedHashSet<>();
  private Map<Integer, Boolean> isUnique = new HashMap<>();
  
  public FirstUnique(int[] nums) {
    for (int num : nums) {
      this.add(num);
    }
  }
    
  public int showFirstUnique() {
    // If the queue contains values, we need to get the first one from it.
    // We can do this by making an iterator, and getting its first item.
    if (!setQueue.isEmpty()) {
       return setQueue.iterator().next();
    }
    return -1;
  }
    
  public void add(int value) {
    // Case 1: This value is not yet in the data structure.
    // It should be ADDED.
    if (!isUnique.containsKey(value)) {
      isUnique.put(value, true);
      setQueue.add(value);
    // Case 2: This value has been seen once, so is now becoming
    // non-unique. It should be REMOVED.
    } else if (isUnique.get(value)) {
      isUnique.put(value, false);
      setQueue.remove(value);
    }
  }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */