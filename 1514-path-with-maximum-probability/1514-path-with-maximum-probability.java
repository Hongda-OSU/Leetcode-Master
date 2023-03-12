class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(new Pair(edges[i][1], succProb[i]));
            list[edges[i][1]].add(new Pair(edges[i][0], succProb[i]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {  
            public int compare(Pair a, Pair b) {
                if(a.prob < b.prob) return 1;
                else if(a.prob > b.prob) return -1;
                return 0;
            }
        }); 
        pq.offer(new Pair(start, 1));
        Set<Integer> visited = new HashSet<>();
        double result = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.node == end)
                result = Math.max(result, curr.prob);
            visited.add(curr.node);
            for (Pair next : list[curr.node]) {
                if (!visited.contains(next.node))
                    pq.offer(new Pair(next.node, next.prob * curr.prob));
            }
        } 
        return result == Integer.MIN_VALUE ? 0 : result;
    }
}

class Pair {
    public int node;
    public double prob;
    public Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}