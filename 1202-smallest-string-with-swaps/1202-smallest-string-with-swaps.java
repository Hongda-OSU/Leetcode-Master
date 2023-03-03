class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for (List<Integer> pair : pairs) {
            int source = pair.get(0);
            int destination = pair.get(1);
            uf.union(source, destination);
        }
        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        for (int vertex = 0; vertex < s.length(); vertex++) {
            int root = uf.find(vertex);
            rootToComponent.putIfAbsent(root, new ArrayList<>());
            rootToComponent.get(root).add(vertex);
        }
        char[] smallestString = new char[s.length()];
        for (List<Integer> indices : rootToComponent.values()) {
            List<Character> characters = new ArrayList<>();
            for (int index : indices)
                characters.add(s.charAt(index));
            Collections.sort(characters);
            for (int i = 0; i < indices.size(); i++) 
                smallestString[indices.get(i)] = characters.get(i);
        }
        return new String(smallestString);
    }
}

class UnionFind {
    private int[] root, rank;
    
    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x) {
        if (x == root[x]) 
            return x;
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y) {
        int f1 = find(x);
        int f2 = find(y);
        if (f1 != f2) {
            if (rank[f1] >= rank[f2]) {
                root[f2] = f1;
                rank[f1] += rank[f2];
            } else {
                root[f1] = f2;
                rank[f2] += rank[f1];
            }
        }
    }
}