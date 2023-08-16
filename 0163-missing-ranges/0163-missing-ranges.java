class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int prev = lower;
        
        for (int num : nums) {
            if (num > upper)
                break;
            if (num < prev)
                continue;
            if (num > prev)
                result.add(Arrays.asList(prev, num - 1));
            prev = num + 1;
        }
        
        if (prev <= upper) 
            result.add(Arrays.asList(prev, upper));
            
        return result;
    }
}