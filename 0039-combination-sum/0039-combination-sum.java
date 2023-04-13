class Solution {
    
     void findAllways(int[] candidates,List<List<Integer>> finalList,ArrayList<Integer> list,int i,int target){
        if(target == 0)
            finalList.add(new ArrayList<Integer>(list));
        else{
            for(int j=i;j<candidates.length;j++)
            {
                if(candidates[j]<=target){
                list.add(candidates[j]);
                findAllways(candidates,finalList,list,j,target-candidates[j]);
                list.remove(list.size()-1);
                }
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    
        List<List<Integer>> finalList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        findAllways(candidates,finalList,list,0,target);
        
        return finalList;
    }
    
}