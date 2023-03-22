class Solution {
    public String longestDupSubstring(String s) {
        String result = "";
        int left = 1, right = s.length() - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            String dup = getDup(pivot, s);
            if (dup != null) {
                result = dup;
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return result;
    }
    
    public String getDup(int size, String str) {
        long h = hash(str.substring(0, size));
        HashSet<Long> set = new HashSet<>();
        set.add(h);
        long pow = 1;
        for (int i = 1; i < size; i++) 
            pow = pow * 31;
        int n = str.length();
        for (int i = size; i < n; i++) {
            h = nextHash(pow, h, str.charAt(i - size), str.charAt(i));
            if (!set.add(h))
                return str.substring(i - size + 1, i + 1);
        }
        return null;
    }
    
    public long hash(String str) {
        long h = 0, a = 1;
        int n = str.length();
        for (int k = n; k >= 1; k--) {
            char ch = str.charAt(k - 1);
            h += (ch - 'a' + 1) * a;
            a = a * 31;
        }
        return h;
    }
    
    public long nextHash(long pow, long hash, char left, char right) {
        return (hash - (left - 'a' + 1) * pow) * 31 + (right - 'a' + 1);
    }
}