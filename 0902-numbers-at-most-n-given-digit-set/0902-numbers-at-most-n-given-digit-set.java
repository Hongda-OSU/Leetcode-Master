class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String str = Integer.toString(n);
        int count = str.length(), len = digits.length, result = 0;
        for (int i  = 1; i < count; i++)
            result += (int)Math.pow(len, i);
        boolean flag = false, equal = false;
        for (int i = 0; i < count; i++) {
            equal = false;
            for (int j = len - 1; j >= 0; j--) {
                if (Integer.parseInt(digits[j]) < str.charAt(i) - '0') {
                    result += (j + 1) * ((int)Math.pow(len, count - i - 1));
                    break;
                } else if (Integer.parseInt(digits[j]) == str.charAt(i) - '0') {
                    equal = true;
                } else if (j == 0) {
                    flag = true;
                }
            }
            if (!equal || flag)
                break;
        }
        if (equal)
            result++;
        return result;
    }
}