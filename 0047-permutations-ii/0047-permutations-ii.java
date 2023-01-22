class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(permutations, new ArrayList<>(), nums, new boolean[nums.length]);
        return permutations;
    }
    
    public void backtrack(List<List<Integer>> permutations, ArrayList<Integer> curr, int[] nums, boolean[] used) {
        if (curr.size() == nums.length) {
            permutations.add(new ArrayList<>(curr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
                curr.add(nums[i]);
                used[i] = true;
                backtrack(permutations, curr, nums, used);
                used[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}