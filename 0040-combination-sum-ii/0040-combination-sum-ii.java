class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combine = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, combine, target, 0, result);
        return result;
    }
    
    private void backtrack(int[] candidates, LinkedList<Integer> combine, int target, int curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combine));
            return;
        }
        for (int next = curr; next < candidates.length; next++) {
            if (next > curr && candidates[next] == candidates[next - 1])
                continue;
            int pick = candidates[next];
            if (target - pick < 0) 
                break;
            combine.addLast(pick);
            backtrack(candidates, combine, target - pick, next + 1, result);
            combine.removeLast();
        }
    }
}