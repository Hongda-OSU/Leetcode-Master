class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // Popping all indices with a lower or equal temperature than the current index
            while (!s.isEmpty() && temperatures[i] >= temperatures[s.peek()])
                s.pop();
            // If the stack still has elements, then the next warmer temperature exists!
            if (!s.isEmpty())
                result[i] = s.peek() - i;
            // Inserting current index in the stack: monotonicity is maintained!
            s.push(i);
        }
        return result;
    }
}