class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        int m1 = 0, m2 = 0;
        int l1 = nums1.length, l2 = nums2.length;
        for (int i = 0; i <= (l1 + l2) >>> 1; i++) {
            m1 = m2;
            if (p1 == l1)
                m2 = nums2[p2++];
            else if (p2 == l2)
                m2 = nums1[p1++];
            else if (nums1[p1] < nums2[p2])
                m2 = nums1[p1++];
            else 
                m2 = nums2[p2++];
        }
        if ((l1 + l2) % 2 == 0)
            return (double) (m1 + m2) / 2;
        return m2;
    }
}