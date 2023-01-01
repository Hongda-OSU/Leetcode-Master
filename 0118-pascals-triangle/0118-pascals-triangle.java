class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // base case
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);
        for (int row = 1; row < numRows; row++) {
            List<Integer> curr = new ArrayList<Integer>();
            List<Integer> prev = result.get(row - 1);
            curr.add(1);
            for (int j = 1; j < row; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
            result.add(curr);
        }
        return result;
    }
}