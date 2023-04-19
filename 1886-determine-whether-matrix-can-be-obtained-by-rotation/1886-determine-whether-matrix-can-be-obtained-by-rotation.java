class Solution {
     public boolean findRotation(int[][] m, int[][] t) {
        BitSet r = new BitSet(4);//4 bits for each rotation, i bit false -> i rotation equals to m
        for (int i = 0, n = m.length - 1; i < m.length; i++)
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] != t[i][j]) r.set(0, true);
                if (m[i][j] != t[j][n - i]) r.set(1, true);
                if (m[i][j] != t[n - i][n - j]) r.set(2, true);
                if (m[i][j] != t[n - j][i]) r.set(3, true);
            }
        return r.cardinality() != 4;
    }
}