public class Solution {
boolean[] visit = new boolean[9];
int ret = 0;
public int numberOfPatterns(int m, int n) {
    for(int i = 0; i < 9; i++){
        visit[i] = true;
        helper(i, 1, m, n);
        visit[i] = false;
    }
    return ret;
}
private void helper(int node, int k, int m, int n){
    if(k >= m){
        ret++;
        if(k == n) return;
    }
    for(int i = 0; i < 9; i++){
        if(check(node, i)){
            visit[i] = true;
            helper(i, k + 1, m, n);
            visit[i] = false;
        }
    }
}
private boolean check(int a, int b){
    if(visit[b]) return false;
    int rowDis = Math.abs(a / 3 - b / 3);
    int colDis = Math.abs(a % 3 - b % 3);
    if(rowDis == 2 && colDis == 2) return visit[4];
    if(rowDis == 2 && colDis == 0) return visit[1 * 3 + a % 3];
    if(rowDis == 0 && colDis == 2) return visit[a / 3 * 3 + 1];
    return true;
}
}