class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
        hMap.put('I', 1);
        hMap.put('V', 5);
        hMap.put('X', 10);
        hMap.put('L', 50);
        hMap.put('C', 100);
        hMap.put('D', 500);
        hMap.put('M', 1000);
        
        int result = hMap.get(s.charAt(0));
        for(int i = 1;i < s.length(); i++){
            if(hMap.get(s.charAt(i)) <= hMap.get(s.charAt(i - 1))){
                result += hMap.get(s.charAt(i));
            } else {
                //减去上一个循环中多加的数字
                result = result - 2 * hMap.get(s.charAt(i - 1)) + hMap.get(s.charAt(i));
            }
        }
        return result;
    }
}