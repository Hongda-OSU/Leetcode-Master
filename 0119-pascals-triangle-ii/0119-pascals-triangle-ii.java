class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int row = 0; row <= rowIndex; row++) {
            result.add(1);
            for (int prev = row - 1; prev > 0; prev--) {
                result.set(prev, result.get(prev - 1) + result.get(prev));
            }
        }
        return result;
    }
}