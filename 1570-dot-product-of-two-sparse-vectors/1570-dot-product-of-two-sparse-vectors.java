class SparseVector {
    // Map the index to value for all non-zero values in the vector
    Map<Integer, Integer> mapping;      

    SparseVector(int[] nums) {
        mapping = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                mapping.put(i, nums[i]);        
            }
        }
    }

    public int dotProduct(SparseVector vec) {        
        int result = 0;

        // iterate through each non-zero element in this sparse vector
        // update the dot product if the corresponding index has a non-zero value in the other vector
        for (Integer i : this.mapping.keySet()) {
            if (vec.mapping.containsKey(i)) {
                result += this.mapping.get(i) * vec.mapping.get(i);
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);