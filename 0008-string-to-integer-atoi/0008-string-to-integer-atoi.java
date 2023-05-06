class Solution {
    public int myAtoi(String s) {
        if (s.equals(""))
            return 0;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        int sign = s.charAt(0) == '-' ? -1 : 1;
        long result = 0;
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i)))
                break;
            result = result * 10 + s.charAt(i) - '0';
            if (sign == -1 && -1 * result < min)
                return min;
            if (sign == 1 && result > max)
                return max;
            i++;
        }
        return (int)(sign * result);
    }
}