class Solution {
    public String shortestPalindrome(String s) {
        String tmp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(tmp);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }
    
    public int[] getTable(String str) {
        int[] table = new int[str.length()];
        int idx = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(idx) == str.charAt(i)) {
                table[i] = table[i - 1] + 1;
                idx++;
            } else {
                idx = table[i - 1];
                while(idx > 0 && str.charAt(idx) != str.charAt(i))
                    idx = table[idx - 1];
                if (str.charAt(idx) == str.charAt(i))
                    idx++;
                table[i] = idx;
            }
        }
        return table;
    }
}