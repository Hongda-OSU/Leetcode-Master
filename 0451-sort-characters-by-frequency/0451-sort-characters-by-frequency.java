class Solution {
    public String frequencySort(String s) {
        // Count the occurence on each character
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        // Build heap
        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());
        // Build string
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            char ch = heap.poll();
            for (int i = 0; i < map.get(ch); i++)
                sb.append(ch);
        }
        return sb.toString();
    }
}