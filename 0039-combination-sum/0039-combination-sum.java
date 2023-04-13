class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // sort to terminate early when target < 0
        backtracking(0, target, candidates, new LinkedList<>());
        return ans;
    }
    void backtracking(int i, int target, int[] candidates, LinkedList<Integer> path) {
        if (target == 0) {
            ans.add((List<Integer>) path.clone());
            return;
        }
        if (i == candidates.length || target < candidates[i]) return;
        
        path.addLast(candidates[i]);
        backtracking(i, target - candidates[i], candidates, path); // Choose ith candidate
        path.removeLast();
        
        backtracking(i + 1, target, candidates, path); // Skip ith candidate
    }
}