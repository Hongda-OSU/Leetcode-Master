class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {

        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i=0;i<nums2.length;i++)
        {
            hm.put(nums2[i],i);
        }

        for(int i=0;i<nums2.length;i++)
        {
            nums2[i] = hm.get(nums1[i]);
        }

        return nums2;
    }
}