class Solution {
    public Map<Integer, Integer> map = new HashMap<>(Map.of(0, 0, 1, 1));
    public int fib(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, fib(n-1) + fib(n-2));
        return map.get(n);
    }
}