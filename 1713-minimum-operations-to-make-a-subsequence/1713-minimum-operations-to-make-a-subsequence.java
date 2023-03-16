class Solution {
    public int minOperations(int[] target, int[] A) {
        Map<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            h.put(target[i], i);
        }
        TreeSet<Integer> stack = new TreeSet<>();
        for (int a : A) {
            if (!h.containsKey(a)) {
                continue;
            }
            if (stack.isEmpty() || stack.last() < h.get(a)) {
                stack.add(h.get(a));
                continue;
            }
            int key = stack.ceiling(h.get(a));
            stack.remove(key);
            stack.add(h.get(a));
        }
        return target.length - stack.size();
    }
}