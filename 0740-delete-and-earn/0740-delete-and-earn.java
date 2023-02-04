class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // prevIncEarn = Earning if previous num is included (not-deleted)  
        // prevExcEarn = Earning if previous num is excluded (deleted)
        int prevIncEarn = 0, prevExcEarn = 0;
        for (int num = min; num <= max; num++) {
            // incEarn = Earning if this num is included (not-deleted)
            // excEarn = Earning if this num is excluded (deleted)
            int incEarn = prevExcEarn + num * count.getOrDefault(num, 0);
            int excEarn = Math.max(prevIncEarn, prevExcEarn);
            prevIncEarn = incEarn;
            prevExcEarn = excEarn;
        }
        return Math.max(prevIncEarn, prevExcEarn);
    }
}