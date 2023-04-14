class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n == 1)
            return false;
        if (n == 2)
            return s.substring(0, 1).equals(s.substring(1));
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                String str = s.substring(0, n / i);
                int count = 0;
                for (int j = n / i; j < n; j += n / i) {
                    if (s.substring(j, j + n / i).equals(str))
                        count++;
                    else {
                        count = 0;
                        break;
                    }
                }
                if (count == i - 1)
                    return true;
            }
        }
        int a = s.charAt(0);
        for (char ch : s.toCharArray()) {
            if (a != ch)
                return false;
        }
        return true;
    }
}