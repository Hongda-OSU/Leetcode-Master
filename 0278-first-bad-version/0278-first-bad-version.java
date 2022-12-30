/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0, right = n, pivot;
        while (left < right) {
            pivot = left + (right - left) / 2;
            if (isBadVersion(pivot)) right = pivot;
            else left = pivot + 1;
        }
        return left;
    }
}