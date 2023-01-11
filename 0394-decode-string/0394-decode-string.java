class Solution {
    public String decodeString(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) queue.offer(ch);
        return decode(queue);
    }
    
    public String decode(Deque<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            if (Character.isDigit(ch)) {
                // get the digit
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                String str = decode(queue);
                for (int i = 0; i < num; i++)
                    sb.append(str);
                num = 0;
            } else if (ch == ']') {
                break;
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}