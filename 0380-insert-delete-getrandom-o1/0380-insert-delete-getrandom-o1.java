public class RandomizedSet {
	Random random;
	Map<Integer, Integer> map;
	List<Integer> list;
	public RandomizedSet() {
		random = new Random();
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) return false;
		list.add(val);
		return map.put(val, list.size()-1) == null;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) return false;
		Integer position = map.get(val);
		Collections.swap(list, position, list.size() - 1);
		map.put(list.get(position),position);
		list.remove(list.size()-1);
		return map.remove(val) != null;
	}

	public int getRandom() {
		int i = random.nextInt(list.size());
		return list.get(i);
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */