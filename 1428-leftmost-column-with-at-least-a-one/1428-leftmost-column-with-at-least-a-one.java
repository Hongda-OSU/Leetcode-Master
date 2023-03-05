/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int columns = binaryMatrix.dimensions().get(1);
        int idx = columns;
        for (int row = 0; row < rows; row++) {
            int low = 0, high = columns - 1;
            while (low < high) {
                int pivot = (low + high) >>> 1;
                if (binaryMatrix.get(row, pivot) == 0)
                    low = pivot + 1;
                else 
                    high = pivot;
            }
            if (binaryMatrix.get(row, low) == 1)
                idx = Math.min(idx, low);
        }
        return idx == columns ? -1 : idx;
    }
}