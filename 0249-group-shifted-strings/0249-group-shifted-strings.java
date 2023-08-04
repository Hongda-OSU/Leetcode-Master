class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String hashKey = getHash(str);
            if (!map.containsKey(hashKey)) 
                map.put(hashKey, new ArrayList<>());
            map.get(hashKey).add(str);
        }
        List<List<String>> groups = new ArrayList<>();
        for (List<String> group : map.values()) 
            groups.add(group);
        return groups;
    }
    
    private String getHash(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            sb.append((char)((arr[i] - arr[i - 1] + 26) % 26 + 'a'));
        }
        return sb.toString();
    }
}