class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        ArrayList<Integer> copy = new ArrayList<>();
        for (int num : nums) copy.add(num);
        backtrack(result, copy, 0, nums.length);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, ArrayList<Integer> curr, int start, int len) {
        if (start == len) result.add(new ArrayList<>(curr));
        for (int i = start; i < len; i++) {
            Collections.swap(curr, start, i);
            backtrack(result, curr, start + 1, len);
            Collections.swap(curr, start, i);
        }
    }
}