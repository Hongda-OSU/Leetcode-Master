class ExamRoom {
    
    private PriorityQueue<int[]> pq;
    private int N;

    public ExamRoom(int N) {
        this.N = N;
        pq = new PriorityQueue<>((a, b) -> {
            if ((b[1] - b[0]) / 2 == (a[1] - a[0]) / 2) {
                return a[0] - b[0];
            }
            return (b[1] - b[0]) / 2 - (a[1] - a[0]) / 2;
        });
    }
    
    public int seat() {
        if (pq.size() == 0) {
            pq.offer(new int[]{0, 2 * (N - 1)});
            return 0;
        } else {
            int[] longest = pq.poll();
            int result = longest[0] + (longest[1] - longest[0]) / 2;
            if (result != 0) { // result = 0, we don't need to add the left side
                pq.offer(new int[]{longest[0], result});
            }
            if (result != N - 1) { // result = N - 1, we don't need to add the right side
                pq.offer(new int[]{result, longest[1]});
            }
            return result;
        }
    }
    
    public void leave(int p) {
        if (pq.size() == 1 && (pq.peek()[1] >= N || pq.peek()[0] < 0)) { // Edge cases: Only [0, 2N] or [-N , N] in pq
            pq.clear();
            return;
        }
        int[] p1 = null, p2 = null; // p1: left side, p2: right side
        for (int[] pair : pq) {
            if (pair[1] == p) {
                p1 = pair;
            }
            if (pair[0] == p) {
                p2 = pair;
            }
        }
        if (p1 != null) {
            pq.remove(p1);
        }
        if (p2 != null) {
            pq.remove(p2);
        }
        if (p1 == null || p1[0] < 0) { // No left side found or p is the left most position in current seats.
            p1 = new int[]{-p2[1], p};
        }
        if (p2 == null || p2[1] >= N) { // No right side found or p is the right most position in current seats.
            p2 = new int[]{p, p1[0] + 2 * (N - p1[0] - 1)};
        }
        pq.offer(new int[]{p1[0], p2[1]});
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */