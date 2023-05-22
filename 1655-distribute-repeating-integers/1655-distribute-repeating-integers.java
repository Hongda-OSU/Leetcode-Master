class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] arr = new int[1001];
        int max = 0;
        for (int n : nums){
            max = Math.max(++arr[n], max);
        }
        int min = Arrays.stream(quantity).max().getAsInt();
        if (max < min){ // optimization 2
            return false;
        }
        int[] map = new int[max+1]; // freq map
        BitSet bit = new BitSet();
        for (int i = 0; i <= 1000; i++) if (arr[i] > 0){ // optimization 1
            map[arr[i]]++;
            bit.set(arr[i]);
        }
        return solve(0, map, quantity, bit);
    }

    private boolean solve(int idx, int[] map, int[] q, BitSet bit){
        if (idx==q.length){
            return true;
        }
        for (int key = bit.nextSetBit(0); key >= 0; key = bit.nextSetBit(key+1)){
            if (q[idx]>key){
                continue;
            }
            if (--map[key]==0){ // optimization 3
                bit.clear(key);
            }
            if (key-q[idx]>0){
                map[key-q[idx]]++;
                bit.set(key-q[idx]);
            }
            if (solve(idx+1, map, q, bit)){
                return true;
            }
            if (key-q[idx]>0&&--map[key-q[idx]]==0){
                bit.clear(key-q[idx]);
            }
            if (++map[key]==1){
                bit.set(key);
            }
        }
        return false;
    }
}