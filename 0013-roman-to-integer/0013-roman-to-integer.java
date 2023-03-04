class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    
    public int romanToInt(String s) {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        
        int result = 0, i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String doubleStr = s.substring(i, i + 2);
                if (map.containsKey(doubleStr)) {
                    result += map.get(doubleStr);
                    i += 2;
                    continue;
                }
            }
            String singleStr = s.substring(i, i + 1);
            result += map.get(singleStr);
            i += 1;
        }
        return result;
    }
}