class Solution {
    public boolean canMeasureWater(int m, int n, int d) {
        if(m + n < d) return false;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);
        int curr = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            if(top==d) return true;
            if(top+m<=m+n && !visited.contains(top+m)){
                q.add(top+m);
                visited.add(top+m);
            }
            if(top-m>=0 && !visited.contains(top-m)){
                q.add(top-m);
                visited.add(top-m);
            }
            if(top+n<=m+n && !visited.contains(top+n)){
                q.add(top+n);
                visited.add(top+n);
            }
            if(top-n>=0 && !visited.contains(top-n)){
                q.add(top-n);
                visited.add(top-n);
            }
        }
        return false;
    }
}