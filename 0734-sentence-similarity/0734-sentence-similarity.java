class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length!=sentence2.length){
            return false;
        }
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        String temp1,temp2;
        for (List<String> liss: similarPairs){
            temp1 = liss.get(0);
            temp2 = liss.get(1);
            if (map.containsKey(temp1)){
                map.get(temp1).add(temp2);
                //liss.add(temp2);
            }
            else{
                //List<String> liss = new ArrayList<>();
                //liss.add(temp2);
                map.put(temp1,new ArrayList<>());
                map.get(temp1).add(temp2);
            }
            if (map.containsKey(temp2)){
                map.get(temp2).add(temp1);
            }
            else{
                map.put(temp2,new ArrayList<>());
                map.get(temp2).add(temp1);
            }
            
        }
        boolean have;
        for (int i = 0;i<sentence1.length;i++){
            if (!sentence1[i].equals(sentence2[i])){
                if (!map.containsKey(sentence1[i])){
                    return false;
                }
                else{
                    List<String> liss = map.get(sentence1[i]);
                    have = false;
                    for (String str: liss){
                        if (str.equals(sentence2[i])){
                            have = true;
                            break;
                        }
                    }
                    if (!have){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}