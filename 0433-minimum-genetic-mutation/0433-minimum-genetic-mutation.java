class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        char[] gens = new char[] {'A', 'C', 'G', 'T'}; 
        queue.add(startGene);
        seen.add(startGene);
        int steps = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int j = 0; j < n; j++) {
                String node = queue.remove();
                if (node.equals(endGene))
                    return steps;
                for (char gen : gens) {
                    for (int i = 0; i < node.length(); i++) {
                        String neighbor = node.substring(0, i) + gen + node.substring(i + 1);
                        if (!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}