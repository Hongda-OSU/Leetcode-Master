public class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        Map<Long, List<Integer>> indexes = new HashMap<>();
        int[][] length = new int[arr.length][arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                List<Integer> ix = indexes.get(arr[i] - (arr[j] - (long) arr[i]));
                if (ix == null) {
                    continue;
                }
                for (int k : ix) {
                    length[i][j] += length[k][i] + 1;
                }
                count += length[i][j];
            }
            indexes.computeIfAbsent((long) arr[i], k -> new ArrayList<>()).add(i);
        }
        return count;
    }
}