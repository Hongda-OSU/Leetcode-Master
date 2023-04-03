class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer>[] map = new List[nums.length];
        for(int i = 0; i < nums.length; i++){
            map[i] = new ArrayList<Integer>();
        }
        for(int i = nums.length-1; i >= 0; i--){
            List<Integer> largest = new ArrayList<>();
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] % nums[i] == 0) {
                    if(largest.size() < map[j].size()) largest = map[j];
                }
            }
            map[i].add(nums[i]);
            map[i].addAll(largest);
            if(res.size() < map[i].size()) res = map[i];
        }
        return res;
    }
}