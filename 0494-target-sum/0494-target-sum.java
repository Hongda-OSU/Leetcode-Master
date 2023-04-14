class Solution {
    private static Map<String, Integer> memo; // key: serialized curIndex and targetSum, value: its corresponding number of ways
    
    public int findTargetSumWays(int[] nums, int S) {
        memo = new HashMap<>();        
        return findTargetSumWaysRecur(nums, S, 0, S);
    }
    
    private static int findTargetSumWaysRecur(int[] nums, int S, int curIndex, int targetSum) {
        
        String curSerial= serialize(curIndex, targetSum);
        if (memo.containsKey(curSerial)) {
            return memo.get(curSerial);
        }
        
        if (curIndex == nums.length) {
            if (targetSum == 0) {
                return 1;
            }
            return 0;
        }
        
        int numWaysIfMinus = findTargetSumWaysRecur(nums, S, curIndex + 1, targetSum + nums[curIndex]); // -nums[curIndex]
        int numWaysIfAdd = findTargetSumWaysRecur(nums, S, curIndex + 1, targetSum - nums[curIndex]); // +nums[curIndex]
        
        int numWays =  numWaysIfMinus + numWaysIfAdd; 
        memo.put(curSerial, numWays);
        return numWays;
    }
    
    private static String serialize(int curIndex, int targetSum) {
        return curIndex + "," + targetSum;
    }
}