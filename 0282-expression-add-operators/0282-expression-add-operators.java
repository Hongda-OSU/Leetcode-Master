class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        if (num.length() == 0)
            return result;
        char[] path = new char[num.length() * 2 - 1];
        char[] digits = num.toCharArray();
        long n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            dfs(result, path, i + 1, 0, n, digits, i + 1, target);
            if (n == 0)
                break;
        } 
        return result;
    } 
    
    private void dfs(List<String> result, char[] path, int length, long left, long curr, char[] digits, int pos, int target) {
        if (pos == digits.length) {
            if (left + curr == target)
                result.add(new String(path, 0, length));
            return;
        }
        long n = 0;
        int j = length + 1;
        for (int i = pos; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[j++] = digits[i];
            path[length] = '+';
            dfs(result, path, j, left + curr, n, digits, i + 1, target);
            path[length] = '-';
            dfs(result, path, j, left + curr, -n, digits, i + 1, target);
            path[length] = '*';
            dfs(result, path, j, left, curr * n, digits, i + 1, target);
            if (digits[pos] == '0')
                break;
        }
    }
}