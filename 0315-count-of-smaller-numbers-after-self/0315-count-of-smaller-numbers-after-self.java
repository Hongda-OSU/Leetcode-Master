public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) min = Math.min(min, nums[i]);;
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min + 1;
            max = Math.max(max, nums[i]);
        }

        List<Integer> res = new ArrayList<>();
        int[] fenwickTree = new int[max + 1];
        for(int i = nums.length - 1; i >= 0; i--) {
            // the index of nums[i] is nums[i] - 1
            // we need to find the sum (-INF, nums[i] - 1], so the index is nums[i] - 2
            res.add(0, getSum(fenwickTree, nums[i] - 2));
            
            // after searching, we need to update the fenwick tree for the next round
            // the new added number is nums[i], but its index of original is nums[i] - 1
            updateFenwickTree(fenwickTree, nums[i] - 1, 1);
        }
        return res;
    }
    
    // the index is the index of original array
    private void updateFenwickTree(int[] fenwickTree, int index, int value) {
        // the index of fenwick tree is one larger than the index of original array
        for(int i = index + 1; i < fenwickTree.length; i += i & (-i)) {
            fenwickTree[i] += value;
        }
    }
    
    // the index is the index of original array
    private int getSum(int[] fenwickTree, int index) {
        int sum = 0;
        // the index of fenwick tree is one larger than the index of original array
        for(int i = index + 1; i > 0; i -= i & (-i)) {
            sum += fenwickTree[i];
        }
        return sum;
    }
}