/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *   public:
 *     // Compares 4 different elements in the array
 *     // return 4 if the values of the 4 elements are the same (0 or 1).
 *     // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
 *     // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
 *     public int query(int a, int b, int c, int d);
 *
 *     // Returns the length of the array
 *     public int length();
 * };
 */

class Solution {
    private int cntEqual = 1, cntDiff = 0, indexDiff = -1;
    
    public int guessMajority(ArrayReader reader) {
        int n = reader.length(), queryA = reader.query(0, 1, 2, 3), queryB = reader.query(1, 2, 3, 4);
        guessMajorityHelper(queryA == queryB, 4);
        for (int i = 5; i < n; i++) {
            guessMajorityHelper(reader.query(1, 2, 3, i) == queryA, i);
        }
        guessMajorityHelper(reader.query(0, 2, 3, 4) == queryB, 1);
        guessMajorityHelper(reader.query(0, 1, 3, 4) == queryB, 2);
        guessMajorityHelper(reader.query(0, 1, 2, 4) == queryB, 3);
        return cntEqual > cntDiff ? 0 : cntDiff > cntEqual ? indexDiff : -1;
    }
    
    private void guessMajorityHelper(boolean eq, int i) {
        if (eq) {
            cntEqual++;
        } else {
            cntDiff++;
            indexDiff = i;
        }
    }
}