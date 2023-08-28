class Solution {
    private int K;

    public int[][] highFive(int[][] items) {
        this.K = 5;
        TreeMap<Integer, Queue<Integer>> allScores = new TreeMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!allScores.containsKey(id))
                allScores.put(id, new PriorityQueue<>());
            // insert the score in the min heap
            allScores.get(id).add(score);
            // remove the minimum element from the min heap in case the size of the min heap exceeds 5 
            if (allScores.get(id).size() > this.K)
                allScores.get(id).poll();
        }

        List<int[]> solution = new ArrayList<>();

        for (int id : allScores.keySet()) {
            int sum = 0;
            // min heap contains the top 5 scores
            for (int i = 0; i < this.K; ++i)
                sum += allScores.get(id).poll();
            solution.add(new int[] {id, sum / this.K});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }
}