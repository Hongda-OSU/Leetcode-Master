class Solution {
     public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int[] offset = new int[s.length()];
        IntStream.range(1, s.length()).forEach(i -> offset[i] = s.charAt(i) == ' ' ? 1 : offset[i-1]-1);
        return IntStream.range(0, rows).reduce(0, (a, b) -> a + cols + offset[(a+cols) % s.length()]) / s.length();
    }
}