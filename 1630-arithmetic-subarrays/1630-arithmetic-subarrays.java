class Solution {
     public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i=0; i<l.length; i++) {
            int start = l[i];
            int end = r[i];
            List<Integer> temp = new ArrayList<>();
            for (int j=start; j<end+1; j++) {
                temp.add(nums[j]);
            }
            res.add(checkIsArithmeticSubarrays(temp));
        }
        return res;
    }
    
    public boolean checkIsArithmeticSubarrays(List<Integer> nums) {
        if (nums.size() < 2) return false;
        Collections.sort(nums);
        int delta = nums.get(1) - nums.get(0);
        for (int i=0; i<nums.size() - 1; i++) {
            if (nums.get(i + 1) - nums.get(i) != delta)
                return false;
        }
        return true;
    }
}