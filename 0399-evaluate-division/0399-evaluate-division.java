class Solution {
    private HashMap<String, ArrayList<Pair>> graph = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0), v = equations.get(i).get(1);
            double w = values[i];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, 1 / w));
        }
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0), v = queries.get(i).get(1);
            double q = graph.containsKey(u) ? dfs(u, v, new HashSet<>()) : -1.0;
            result[i] = q;
        }
        return result;
    }
    
    private double dfs(String u, String v, HashSet<String> visited) {
        visited.add(u);
        if (u.equals(v))
            return 1;
        double result = 1;
        for (Pair p : graph.get(u)) {
            if (!visited.contains(p.str)) {
                double d = dfs(p.str, v, visited);
                if (d > 0)
                    return p.w * d;
            }
        }
        return -1.0;
    }
}

class Pair {
    public String str;
    public double w;
    
    public Pair(String str, double w) {
        this.str = str;
        this.w = w;
    }
    
    public String toString() {
        return str + " " + w;
    }
}