/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
        while (left < right) {
            int pivot = (left + right) >>> 1;
            if (mountainArr.get(pivot) < mountainArr.get(pivot + 1))
                left = pivot + 1;
            else 
                right = pivot;
        }
        int peak = left;
        left = 0; right = peak;
        while (left <= right) {
            int pivot = (left + right) >>> 1;
            if (mountainArr.get(pivot) < target)
                left = pivot + 1;
            else if (mountainArr.get(pivot) > target)
                right = pivot - 1;
            else 
                return pivot;
        }
        left = peak; right = mountainArr.length() - 1;
        while (left <= right) {
            int pivot = (left + right) >>> 1;
            if (mountainArr.get(pivot) < target)
                right = pivot - 1;
            else if (mountainArr.get(pivot) > target) 
                left = pivot + 1;
            else
                return pivot;
        } 
        return -1;
    }
}