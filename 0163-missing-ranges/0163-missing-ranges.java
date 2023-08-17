class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int start = lower;
        
        for (int num : nums) {
            if (num > start)
                result.add(Arrays.asList(start, num - 1));
            start = num + 1;
        }
        
        if (start <= upper) 
            result.add(Arrays.asList(start, upper));
            
        return result;
    }
}