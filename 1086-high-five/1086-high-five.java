class Solution {

    private int K;

    public int[][] highFive(int[][] items) {
        this.K = 5;
        Arrays.sort(
                items,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        if (a[0] != b[0])
                            // item with lower id goes first
                            return a[0] - b[0];
                        // in case of tie for ids, item with higher score goes first
                        return b[1] - a[1];
                    }
                });
        List<int[]> solution = new ArrayList<>();
        int n = items.length;
        int i = 0;
        while (i < n) {
            int id = items[i][0];
            int sum = 0;
            // obtain total using the top 5 scores
            for (int k = i; k < i + this.K; ++k)
                sum += items[k][1];
            // ignore all the other scores for the same id
            while (i < n && items[i][0] == id)
                i++;
            solution.add(new int[] {id, sum / this.K});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }
}