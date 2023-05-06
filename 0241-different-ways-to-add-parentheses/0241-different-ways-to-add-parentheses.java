class Solution {
    public List<Integer> diffWaysToCompute(String str) { 
        HashMap<String,List<Integer>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'){
                List<Integer> left = map.getOrDefault(str,diffWaysToCompute(str.substring(0,i)));
                List<Integer> right = map.getOrDefault(str,diffWaysToCompute(str.substring(i+1)));
                for(Integer c1 : left){
                    for(Integer c2 : right){
                        if(ch == '+'){
                            res.add(c1+c2);
                        }
                        else if(ch == '-'){
                            res.add(c1-c2);
                        }
                        else if(ch == '*'){
                            res.add(c1*c2);
                        }
                    }
                }
            }
        }
        if(res.size()==0)res.add(Integer.parseInt(str));
        map.put(str,res);
        return res;
    }
}