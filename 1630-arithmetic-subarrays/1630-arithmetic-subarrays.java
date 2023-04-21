class Solution {
    private static boolean[] checked;
    
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        int n = l.length;
        for (int i = 0; i < n; i++)
            result.add(check(nums, l[i], r[i]));
        return result;
    }
    
    private boolean check(int[] nums, int left, int right) {
        int diff = right - left;
        if (diff == 0)
            return true;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if ((max - min) % diff != 0)
            return false;
        int temp = (max - min) / diff;
        if (temp == 0)
            return true;
        checked = new boolean[max - min + 1];
        for (int i = left; i <= right; i++) {
            int currDiff = nums[i] - min;
            if (checked[currDiff] || currDiff % temp != 0)
                return false;
            checked[currDiff] = true;
        }
        return true;
    }
}