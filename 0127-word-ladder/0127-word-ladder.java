class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                char[] curr = queue.poll().toCharArray();
                for (int j = 0; j < curr.length; j++) {
                    char tmp = curr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        curr[j] = ch;
                        String next = new String(curr);
                        if (set.contains(next)) {
                            if (next.equals(endWord))
                                return count + 1;
                            queue.add(next);
                            set.remove(next);
                        }
                    }
                    curr[j] = tmp;
                }
            }
            count++;
        }
        return 0;
    }
}