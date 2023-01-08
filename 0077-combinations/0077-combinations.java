class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new LinkedList<>(), 1, n, k);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, LinkedList<Integer> current, int first, int n, int k) {
        if (current.size() == k) result.add(new LinkedList<>(current));
        for (int i = first; i < n + 1; i++) {
            current.add(i);
            backtrack(result, current, i + 1, n, k);
            current.removeLast();
        }
    }
}