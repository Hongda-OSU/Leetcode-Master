class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return result;
        getSubSets(nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    public void getSubSets(int[] nums, List<Integer> temp, int index) {
        // base condition
        if(index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // case 1 : we pick the element
        temp.add(nums[index]);
        getSubSets(nums, temp, index + 1); // move ahead
        temp.remove(temp.size() - 1);
         
		// case 2 : we don't pick the element ( notice, we did not add the current element in our temporary list
        getSubSets(nums, temp, index + 1); // move ahead
    }
}