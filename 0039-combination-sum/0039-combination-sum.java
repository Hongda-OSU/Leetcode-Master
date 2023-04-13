class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getTargetCombination(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    private void getTargetCombination(int[] candidates, int position, int target, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        } 
        if (position == candidates.length)
            return;
        if (candidates[position] <= target) {
            list.add(candidates[position]);
            getTargetCombination(candidates, position, target - candidates[position], list);
            list.remove(list.size() - 1);
        }
        getTargetCombination(candidates, position + 1, target, list);
    }
}
