class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] root = new int[26];
        for (int i = 0; i < 26; i++)
            root[i] = i;
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                union(root, x, y);
            } 
        }
        for (String eq : equations) {
             if (eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                if (find(root, x) == find(root, y))
                    return false;
            }
        }
        return true;
    }
    
    public void union(int[] root, int x, int y) {
        x = find(root, x);
        y = find(root, y);
        if (x != y)
            root[x] = y;
    }
    
    public int find(int[] root, int i) {
        if (root[i] != i)
            root[i] = find(root, root[i]);
        return root[i];
    }  
}