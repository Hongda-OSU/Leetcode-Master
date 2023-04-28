class Solution {
   public int maxCoins(int[] nums) {
	// add dummy head and tail
    int helpNum[] = new int[nums.length + 2]; 
    for(int i = 1; i <= nums.length; i++)
        helpNum[i] = nums[i - 1];
    helpNum[0] = 1;
    helpNum[nums.length + 1] = 1;
	
    int sum[][] = new int[helpNum.length][helpNum.length];
    for(int gap = 0; gap < nums.length; gap++) {
        for(int begin = 1; begin < nums.length - gap + 1; begin++) { // we don't consider the dummy head and tail
            int end = begin + gap;
            sum[begin][end] = Integer.MIN_VALUE;
            int left = helpNum[begin - 1];
            int right = helpNum[end + 1];
			
			// head and tail for current subrange need to be special processed
            sum[begin][end] = Math.max(sum[begin][end], sum[begin + 1][end] + helpNum[begin] * left * right);
            sum[begin][end] = Math.max(sum[begin][end], sum[begin][end - 1] + helpNum[end] * left * right);
			
            for(int j = begin + 1; j < end; j++)
                sum[begin][end] = Math.max(sum[begin][end], sum[begin][j - 1] + sum[j + 1][end] + helpNum[j] * left * right);
        }
    }
    return sum[1][nums.length];
}
}