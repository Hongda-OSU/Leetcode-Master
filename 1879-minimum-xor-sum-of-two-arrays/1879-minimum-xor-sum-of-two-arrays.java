class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        // This method requires the use of dynamic programming. 
        // Notice that since n is small, we can use bitwise operations to observe quickly which elements in nums2 have been chosen so far.
        // So for example if nums2 has 3 elements, we can use 100 to denote the 1st item in nums2 was chosen,
        // 010 to denote the 2nd item in nums2 was chosen, 001 to denote the 3rd item was chosen, etc.
        
        // Firstly, we calculate all the possible XOR values and store into the HashMap shown here.
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int n = nums1.length;
        
        // We also set up the dp matrix. The row number indicates which index in nums1 we are looking at now.
        // The col number indicates the bitwise notation as explained earlier. The largest possible bitwise notation is (1<<n)-1
        // Why? Because if we have 3 elements, that means that largest possible notation we can get is 111 (all 3 elements in nums2 have been chosen already)
        // (1<<n)-1 is a shorthand to give the value 111
        // Since we are finding the minimum value, we preset everything to Infinity
        int[][] dp = new int[n][(1<<n)+1];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // This is the place where I calculate all the possible XOR values and store into the HashMap.
        // The key of this map is which index I am currently in inside nums1 array.
        // The nested HashMap<Integer,Integer> has the bitwise notation as its key, and the XOR value as its value.
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (j==0) map.put(i, new HashMap<Integer,Integer>());
                int temp = nums1[i] ^ nums2[j];
                map.get(i).put((1<<j), temp);
                
                // Here, I am just saying that just by looking at index 0 of nums1 array, I can find the best possible result so far.
                // Since this method iterates in order (index 0 --> index 1 --> index 2 of nums1 array) to find the best result at each step,
                // it means that the best possible result so far just by looking at index 0 of nums1 array, is every possible combination
                // with the nums2 array. Hence, we can just initialize these values for all possible combinations with the index 0 of nums1
                if (i==0) dp[i][(1<<j)] = temp;
            }
        }
        
        // Finally, our dp!
        // If the value is Infinity, it means we haven't found our best solution for that yet. Skip!
        // Otherwise, we check the HashMap at the next index of nums1 array. 
        // Complete search through all the possible bitwise notations, to find all the possible 'next steps'.
        // Remember the bitwise notation stored in the HashMap each has exactly one zero only, to denote which item in nums2 I had chosen.
        // A 'next step' is possible if the bitwise notation and my current col number do NOT have any overlaps.
        // If there are overlaps, it means that I had chosen that particular element in nums2 array before, and I should not do anything.
        // So, we can use (bitwise notation & j) == 0 to check if there are NO overlaps
        // Only if there are no overlaps, we can find the next best state in our dp. We can do (bitwise notation|j) to combine those two together (so basically, adding a 1 into our col number) and then modifying the result using the classical Math.min method
        
        for (int i=0;i<dp.length-1;i++){
            for (int j=0;j<dp[0].length;j++){
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                HashMap<Integer,Integer> map2 = map.get(i+1);
                for (int bitcode: map2.keySet()) {
                    if ((bitcode & j) == 0){
                        dp[i+1][bitcode|j] = Math.min(dp[i+1][bitcode|j], dp[i][j] + map2.get(bitcode));
                    }
                }
            }
        }
        
        // Our answer lies in this particular region, where we are looking at index n-1 of nums1 array (the end of the array), as well
        // as having chosen ALL elements in nums2 array (given by 111111 depending on the value of n) which is simply (1<<n)-1 as explained above.
        return dp[n-1][(1<<n)-1];
        
        // This question is similar to question 1799, where I employed a similar approach.
    }
}