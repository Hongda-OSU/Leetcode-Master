class Solution {
    public String stringShift(String s, int[][] shift) {
        int direction = 0;
        for (int[] pair : shift) {
            if (pair[0] == 0)
                direction -= pair[1];
            else 
                direction += pair[1];
        }
        return shift(s, direction);
    }
    
    public String shift(String str, int direction) {
        if (direction == 0)
            return str;
        direction = direction % str.length();
        if (direction < 0)
            direction = str.length() - Math.abs(direction);
        char[] result = new char[str.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int idx = (i + direction) % str.length();
            result[idx] = str.charAt(i);
        }
        for (char ch : result) 
            sb.append(ch);
        return sb.toString();
    }
}