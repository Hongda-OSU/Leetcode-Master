class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int i : nums)
            if (map.get(i) > nums.length / 2) return i;
        return 0;
    }
}