class Solution {
     boolean[] checked;
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {       
        List<Boolean> result = new ArrayList<>();
        int n = l.length;
        for (int i = 0; i < n; i++) {
            result.add(check(nums, l[i], r[i]));
        }
        return result;
    }
    // check unsorted array if it is arithmetic
    private boolean check(int[] nums, int l , int r) {
        int n = r - l;
        if (n == 0) return true;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if ((max - min) % n != 0) return false;
        int diff = (max - min) / n;
        if (diff == 0) return true; // all numbers are equal 
        checked = new boolean[max - min + 1];
        for(int i = l; i <= r; i++) {
            int currentDiff = nums[i] - min; 
			// the current diff with min should happen only once and diff should be its divider
            if (checked[currentDiff] || currentDiff % diff != 0) return false;
            checked[currentDiff] = true;           
        }
        return true;
    }
}