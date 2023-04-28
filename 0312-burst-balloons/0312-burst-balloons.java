class Solution {
   public int maxCoins(int[] nums) {
	// Corner Case
	if(nums == null || nums.length == 0) return 0;
	
	int len = nums.length;
	int[][] dp = new int[len][len];
	

	for(int i = nums.length - 1; i >= 0; i--) {	// i represent the left closed idx of str
		for(int j = i; j <= nums.length - 1; j++) { // j represent the right closed idx 
			for(int k = i; k <= j; k++) {
				int val = 0;
				val += (k == i) ? 0 : dp[i][k-1];
				val += (k == j) ? 0 : dp[k+1][j];
	
				// Here is nums[i-1/j+1] instead of nums[k-1/k+1]
				// Since ?*nums[k]*? executed at last.
				val += ((i==0) ? 1 : nums[i-1]) * nums[k] * ((j==len-1) ? 1 : nums[j+1]);
				dp[i][j] = Math.max(dp[i][j], val);
			}
		}
	}
	return dp[0][len-1];
}
}