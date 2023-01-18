class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        map.put(0, 1);
        for (int num : nums) {
            // get sum at each point
            // ex [1, 2, 3] -> [1, 1+2, 1+2+3]
            sum += num;
            // get all the interval between two consecutive sum, ex: 1+2 - 1 -> 2 == k ?
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}