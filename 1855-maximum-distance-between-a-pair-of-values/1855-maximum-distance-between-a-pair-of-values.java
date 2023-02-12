class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length, result = 0;
        for (int i = 0; i < l1; i++) {
            int k = bst(nums2, nums1[i]);
            if (k > i) 
                result = Math.max(result, k - i);
        }
        return result;
    }
    
    public int bst(int[] nums, int num) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pivot = (left + right + 1) >>> 1;
            if (nums[pivot] < num)
                right = pivot - 1;
            else 
                left = pivot;
        }
        return left;
    } 
}