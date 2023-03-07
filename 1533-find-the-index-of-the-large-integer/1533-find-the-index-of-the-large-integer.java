/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int left = 0, right = reader.length() - 1;
        while (left < right) {
            int pivot = (left + right) >>> 1;
            int tmp = 0;
            if ((right - left) % 2 == 0) 
                tmp = reader.compareSub(left, pivot, pivot, right);
            else
                tmp = reader.compareSub(left, pivot, pivot + 1, right);
            if (tmp == 1)
                right = pivot;
            else if (tmp == -1)
                left = pivot + 1;
            else 
                return pivot;
        }
        return left;
    }
}