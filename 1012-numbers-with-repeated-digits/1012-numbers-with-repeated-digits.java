class Solution {
    public int numDupDigitsAtMostN(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n + 1; i > 0; i /= 10) 
            list.add(0, i % 10);
        int result = 0, size = list.size();
        for (int i = 1; i < size; i++)
            result += 9 * helper(9, i - 1);
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = i > 0 ? 0 : 1; j < list.get(i); j++) {
                if (!visited.contains(j))
                    result += helper(9 - i, size - i - 1);
            }
            if (visited.contains(list.get(i)))
                break;
            visited.add(list.get(i));
        }
        return n - result;
    }
    
    private int helper(int m, int n) {
        return n == 0 ? 1 : helper(m, n - 1) * (m - n + 1);
    }
}