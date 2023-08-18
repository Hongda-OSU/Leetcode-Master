class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {

        List<List<Integer>> ans = new ArrayList();
       for(int i = 0; i < intervals.length; i++){

            int[] in = intervals[i];

            if(in[1] < toBeRemoved[0] || in[0] >= toBeRemoved[1]){
                List<Integer> innerList = new ArrayList();
                innerList.add(in[0]); innerList.add(in[1]);
                ans.add(innerList);
            }else{

                if(in[1] > toBeRemoved[0] && in[0] < toBeRemoved[0]){
                    List<Integer> innerList = new ArrayList();
                    innerList.add(in[0]); innerList.add(toBeRemoved[0]);
                    ans.add(innerList);
                }
                
                if(in[1] > toBeRemoved[1] && in[0] < toBeRemoved[1]){
                    List<Integer> innerList = new ArrayList();
                    innerList.add(toBeRemoved[1]); innerList.add(in[1]); 
                    ans.add(innerList);

                }
            }
       }

       return ans;
        
    }
}