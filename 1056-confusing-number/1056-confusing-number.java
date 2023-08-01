class Solution {
    public boolean confusingNumber(int n) {
        Map<Character, Character> inverseMap = new HashMap<>() {{
            put('0', '0');
            put('1', '1');
            put('6', '9');
            put('8', '8');
            put('9', '6');
        }};
        StringBuilder sb = new StringBuilder();
        for (char ch : String.valueOf(n).toCharArray()) {
            if (!inverseMap.containsKey(ch)) 
                return false;
            sb.append(inverseMap.get(ch));
        }
        sb.reverse();
        return Integer.parseInt(sb.toString()) != n;
    }
}