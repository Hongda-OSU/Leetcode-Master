class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> comb = new Stack<>();
        find(candidates, target, comb, 0, result);
        return result;
    }
    private void find(int[] candidates, int target, Stack<Integer> comb, int k, List<List<Integer>> result) {
        for (int i = k; i < candidates.length; i++) {
            if (candidates[i] == target) {
                comb.push(candidates[i]);
                result.add(new ArrayList<>(comb));
                comb.pop();
            } else if (candidates[i] < target) {
                comb.push(candidates[i]);
                find(candidates, target - candidates[i], comb, i, result);
                comb.pop();
            }
        }
    }
}