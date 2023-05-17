class Solution {
     public List<String> summaryRanges(int[] nums) {
        
        ArrayList<String> ans = new ArrayList<>();

        if(nums == null || nums.length == 0)
          return ans;


        int start = 0;
        int end = 0;
        int n = nums.length;
        int i = 0;        
        while(i < n)
        {
            if(i + 1 < n && nums[i + 1] - nums[i] == 1)
            {
                end++;
            }
            else {
              
              if(start == end)
              {
                  ans.add(String.valueOf(nums[end]));
              }
              else{
                  ans.add(nums[start] + "->" + nums[end]);
              }

              end++;
              start = end;
            }
          i++;      
        } 
       return ans;
    }
}