class Solution {
    public String alienOrder(String[] words) {
        // using bfs
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                counts.put(ch, 0);
                adjList.put(ch, new ArrayList<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character ch : counts.keySet()) {
            if (counts.get(ch).equals(0))
                queue.add(ch);
        }
        while (!queue.isEmpty()) {
            Character ch = queue.remove();
            sb.append(ch);
            for (Character next : adjList.get(ch)) {
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next).equals(0))
                    queue.add(next);
            }
        }
        if (sb.length() < counts.size())
            return "";
        return sb.toString();
    }
}