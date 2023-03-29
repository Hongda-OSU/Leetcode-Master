class Solution {
    public List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];
        dfs(n, new ArrayList<String>(), visited, diagonal1, diagonal2, 0);
        return result;
    }
    
    public void dfs(int n, List<String> list, boolean[] visited, boolean[] diagonal1, boolean[] diagonal2, int row) {
        if (row == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            //这一行、正对角线、反对角线都不能再放了，如果发现是true，停止本次循环
            if (visited[i] || diagonal1[row + i] || diagonal2[row - i + n - 1])
                continue;
            //init一个长度为n的一维数组，里面初始化为'.'
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[i] = 'Q';
            String str = new String(arr);
            list.add(str);
            visited[i] = true;
            diagonal1[row + i] = true;
            diagonal2[row - i + n - 1] = true;
            dfs(n, list, visited, diagonal1, diagonal2, row + 1);
            //reset 不影响回溯的下个目标
            list.remove(list.size() - 1);
            arr[i] = '.';
            visited[i] = false;
            diagonal1[row + i] = false;
            diagonal2[row - i + n - 1] = false;
        }
    }
}