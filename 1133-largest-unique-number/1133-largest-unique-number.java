class Solution {
public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        // Store counts of each element
        for (int i : A) {
          count.put(i, count.getOrDefault(i, 0) + 1);
        }
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            // If count of the integer is 1 get maximum.
            if (entry.getValue() == 1) {
              result = Math.max(result, entry.getKey());
            }
        }
        return result;
    }
}