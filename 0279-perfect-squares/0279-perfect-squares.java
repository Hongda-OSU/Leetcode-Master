public class Solution {
    public int numSquares(int n) {

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(n);
        int depth = 1, m = 1, tmp = 0;
        
        while(true){
            if(m == 0){
                depth++;
                m = tmp;
                tmp = 0;
            }
            
            int cur = queue.remove();
            m--;
            
            int l = (int) Math.sqrt(cur);
            for(int i=l; i>0; i--){
                int sq = i*i;
                int delta = cur - sq;
                if(delta == 0)
                    return depth;
                queue.add(delta);
                tmp++;
            }
        }
    }
}