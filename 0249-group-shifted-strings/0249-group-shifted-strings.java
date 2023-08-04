class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> group_map = new HashMap<>();
        for(String s: strings){
            StringBuilder key  = new StringBuilder();
            for(int i = 0; i < s.length();i++){
                int relative_distance = (s.charAt(i) - s.charAt(0) + 26) % 26;
                // in case [0,1,11] [0,11,1], so i add "." to key.
                key.append(".");
                key.append(Integer.toString(relative_distance));
            }
            String k = key.toString();
            if(!group_map.containsKey(k)){
                List<String> value = new ArrayList<>();
                group_map.put(k,value);
            }
            group_map.get(k).add(s);
        }
        System.out.println(group_map);
        
        List<List<String>> output = new ArrayList<>();
        for(String key: group_map.keySet()){
            List<String> value = new ArrayList<>();
            value = group_map.get(key);
            output.add(value);
        }
        return output;
    }
}