class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return findWinner(0, k - 1, list);
    }
    
    public int findWinner(int start, int k, List<Integer> list) {
        if (list.size() == 1) return list.get(0);
        //index which needed to be removed.modulo used just to make with-in boundary of list
        int newStart = (start + k) % list.size();
        list.remove(newStart);
        return findWinner(newStart, k, list);
    }
}