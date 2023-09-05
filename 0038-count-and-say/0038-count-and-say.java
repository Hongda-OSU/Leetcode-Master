class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++)
            str = countIndex(str);
        return str;
    }
    
    private String countIndex(String str) {
        StringBuilder sb = new StringBuilder();
        char ch = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            } else {
                sb.append(count);
                sb.append(ch);
                ch = str.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(ch);
        return sb.toString();
    }
}