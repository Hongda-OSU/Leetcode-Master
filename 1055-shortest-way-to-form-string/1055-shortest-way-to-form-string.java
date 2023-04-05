class Solution {
    public int shortestWay(String source, String target) {
        int i = 0, result = 0;
        while (i != target.length()) {
            int next = findNext(source, target, i);
            if (next == i)
                return -1;
            result++;
            i = next;
        }
        return result;
    }
    
    public int findNext(String source, String target, int i) {
        for (char ch : source.toCharArray()) {
            if (i != target.length()) {
                char curr = target.charAt(i);
                if (curr == ch) 
                    i++;
            }
        }
        return i;
    }
}