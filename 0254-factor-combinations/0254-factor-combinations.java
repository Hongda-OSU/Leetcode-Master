class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(2, n, new LinkedList<>(), result);
        return result;
    }
    
    public void backtrack(int start, int n, List<Integer> list, List<List<Integer>> result) {
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                list.add(n / i);
                result.add(new LinkedList<>(list));
                list.remove(list.size() - 1);
                backtrack(i, n / i, list, result);
                list.remove(list.size() - 1);
            }
        }
    } 
}