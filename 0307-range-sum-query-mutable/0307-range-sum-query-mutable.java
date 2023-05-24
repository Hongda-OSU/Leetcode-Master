class NumArray {
    int[] fenwick;
    
    public NumArray(int[] nums) {
        fenwick = new int[nums.length+1];
        
        for(int i = 1; i < fenwick.length; i++)
            fenwick[i] = nums[i-1];
        for(int i = 1; i < fenwick.length; i++){
            int j = i + LSB(i);
            if(j < fenwick.length)
                fenwick[j] += fenwick[i];
        }
        
    }
    
    public void update(int i, int val) {
        int value = sumRange(i,i);
        add(++i,val - value);
    }
    
    private void add(int i, int val){
        while(i < fenwick.length){
            fenwick[i] += val;
            i += LSB(i);
        }
    }
    
    public int sumRange(int i, int j) {
        i++;
        j++;
        return preSum(j) - preSum(i-1);
    }
    
    private int preSum(int i){
        int sum = 0;
        while(i != 0){
            sum += fenwick[i];
            i -= LSB(i);
        }
        
        return sum;
    }
    
    int LSB(int i){
        return -i & i;
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */