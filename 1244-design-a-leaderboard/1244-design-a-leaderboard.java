class Leaderboard {
    private Map<Integer, Integer> scores;
    private TreeMap<Integer, Integer> sorted;

    public Leaderboard() {
        scores = new HashMap<>();
        sorted = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if (!scores.containsKey(playerId)) {
            scores.put(playerId, score);
            sorted.put(score, sorted.getOrDefault(score, 0) + 1);
        } else {
            int prevScore = scores.get(playerId);
            int playerCount = sorted.get(prevScore);
            if (playerCount == 1) 
                sorted.remove(prevScore);
            else
                sorted.put(prevScore, playerCount - 1);
            int newScore = prevScore + score;
            scores.put(playerId, newScore);
            sorted.put(newScore, sorted.getOrDefault(newScore, 0) + 1);
        }
    }
    
    public int top(int K) {
        int count = 0, sum = 0;
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            for (int i = 0; i < val; i++) {
                sum += key;
                count++;
                if (count == K)
                    break;
            }
            if (count == K)
                break;
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int prevScore = scores.get(playerId);
        sorted.put(prevScore, sorted.get(prevScore) - 1);
        if (sorted.get(prevScore) == 0)
            sorted.remove(prevScore);
        scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */