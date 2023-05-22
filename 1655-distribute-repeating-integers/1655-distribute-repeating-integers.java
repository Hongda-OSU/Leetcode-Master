class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] arr = new int[1001];
        int max = 0;
        for (int num : nums)
            max = Math.max(max, ++arr[num]);
        int min = Arrays.stream(quantity).max().getAsInt();
        if (max < min)
            return false;
        int[] map = new int[max + 1];
        BitSet bit = new BitSet();
        for (int i = 0; i <= 1000; i++) {
            if (arr[i] > 0) {
                map[arr[i]]++;
                bit.set(arr[i]);
            }
        }
        return helper(0, map, quantity, bit);
    }
    
    private boolean helper(int index, int[] map, int[] q, BitSet bit) {
        if (index == q.length)
            return true;
        for (int key = bit.nextSetBit(0); key >= 0; key = bit.nextSetBit(key + 1)) {
            if (q[index] > key)
                continue;
            if (--map[key] == 0) 
                bit.clear(key);
            if (key - q[index] > 0) {
                map[key - q[index]]++;
                bit.set(key - q[index]);
            }
            if (helper(index + 1, map, q, bit))
                return true;
            if (key - q[index] > 0 && --map[key - q[index]] == 0)
                bit.clear(key - q[index]);
            if (++map[key] == 1)
                bit.set(key);
        }
        return false;
    }
}