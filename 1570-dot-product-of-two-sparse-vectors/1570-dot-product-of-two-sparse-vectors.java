class SparseVector {
    private int[] arr;
    
    SparseVector(int[] nums) {
        arr = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int[] vectorArr = vec.getArray();
        int[] arr = getArray();
        int sum = 0;
        for (int i = 0; i < vectorArr.length; i++)
            sum += vectorArr[i] * arr[i];
        return sum;
    } 
    
    private int[] getArray() {
        return arr;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);