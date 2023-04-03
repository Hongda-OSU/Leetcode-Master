class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max = 0, idx = -1;
        int[] count = new int[n], prev = new int[n];
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                idx = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        while (idx != -1) {
            result.add(nums[idx]);
            idx = prev[idx];
        }
        return result;
    }
}