class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new LinkedList<>(), 1, n, k);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, LinkedList<Integer> curr, int first, int n, int k) {
        if (curr.size() == k) result.add(new LinkedList<>(curr));
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            backtrack(result, curr, i + 1, n, k);
            curr.removeLast();
        }
    }
}