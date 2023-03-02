class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] group = new int[26];
        for (int i = 0; i < 26; i++)
            group[i] = i;
        for (int i = 0; i < s1.length(); i++)
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a', group);
        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray())
            sb.append((char)(find(ch - 'a', group) + 'a'));
        return sb.toString();
    }
    
    public void union(int x, int y, int[] group) {
        x = find(x, group);
        y = find(y, group);
        if (x == y)
            return;
        if (x < y)
            group[y] = x;
        else 
            group[x] = y;
    }
    
    public int find(int i, int[] group) {
        if (group[i] == i) 
            return i;
        return group[i] = find(group[i], group);
    } 
}