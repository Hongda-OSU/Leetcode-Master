public class Solution {
    
    Map<Integer,List<Integer>> mem = new HashMap<>();
    
    private List<Integer> helper(int[] nums, int i) {
        if(mem.containsKey(i))
            return mem.get(i);
        List<Integer> maxLenLst = new ArrayList<>();
        int div = i==0 ? 1 : nums[i-1];
        for(int k=i; k<nums.length; k++) {
            if(nums[k] % div == 0) {
                // make a copy is crucial here, so that we won't modify the returned List reference
                List<Integer> lst = new ArrayList<>(helper(nums, k+1)); 
                lst.add(nums[k]);
                if(lst.size() > maxLenLst.size())
                    maxLenLst = lst;
            }
        }
        mem.put(i, maxLenLst);
        return maxLenLst;
    }
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, 0);
    }
}