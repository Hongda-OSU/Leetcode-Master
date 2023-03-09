class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++)
            diff[i] = nums1[i] - nums2[i];
        Arrays.sort(diff);
        int left = 0, right = n - 1;
        long result = 0;
        while (left < right) {
            int sum = diff[left] + diff[right];
            if (sum > 0) {
                result += right - left;
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}