class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Long, List<Integer>> map = new HashMap<>();
        int[][] length = new int[nums.length][nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> list = map.get(nums[i] - (nums[j] - (long)nums[i]));
                if (list == null)
                    continue;
                for (int num : list) 
                    length[i][j] += length[num][i] + 1;
                count += length[i][j];
            }
            map.computeIfAbsent((long) nums[i], num -> new ArrayList<>()).add(i);
        }
        return count;
    }
}