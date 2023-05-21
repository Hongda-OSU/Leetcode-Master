class Solution {
    public int minStickers(String[] stickers, String target) {
        int[] targetArr = new int[26];
        for (char ch : target.toCharArray())
            targetArr[ch - 'a']++;
        int[] index = new int[26];
        int n = 0;
        for (int i = 0; i < 26; i++)
            index[i] = targetArr[i] > 0 ? n++ : -1;
        int[] targetCount = new int[n];
        int t = 0;
        for (int count : targetArr) {
            if (count > 0)
                targetCount[t++] = count;
        }
        int[][] stickersCount = new int[stickers.length][n];
        for (int i = 0; i < stickers.length; i++) {
            for (char ch : stickers[i].toCharArray()) {
                int j = index[ch - 'a'];
                if (j >= 0)
                    stickersCount[i][j]++;
            }
        }
        int start = 0;
        for (int i = 0; i < stickers.length; i++) {
            for (int j = start; j < stickers.length; j++) {
                if (j != i) {
                    int k = 0;
                    while (k < n && stickersCount[i][k] <= stickersCount[j][k])
                        k++;
                    if (k == n) {
                        int[] temp = stickersCount[start];
                        stickersCount[i] = stickersCount[start];
                        stickersCount[start++] = temp;
                        break;
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(targetCount);
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            while (size-- > 0) {
                int[] freq = queue.poll();
                String str = toString(freq);
                if (visited.add(str)) {
                    int first = str.charAt(0) - 'a';
                    for (int i = start; i < stickers.length; i++) {
                        if (stickersCount[i][first] != 0) {
                            int[] next = freq.clone();
                            for (int j = 0; j < n; j++)
                                next[j] = Math.max(next[j] - stickersCount[i][j], 0);
                            if (empty(next))
                                return steps;
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean empty(int[] freq) {
        for(int f: freq) 
            if(f > 0) return false;
        return true;
    }
    
    private String toString(int[] freq) {
        StringBuilder sb = new StringBuilder();
        char ch = 'a';
        for(int f: freq) {
            while(f-- > 0) 
                sb.append(ch);
            ch++;
        }
        return sb.toString();
    }
}