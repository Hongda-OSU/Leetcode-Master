class ExamRoom {
    class Interval {
        int start;
        int end;
        int length;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            if (start == 0 || end == N - 1) {
                this.length = end - start;
            } else {
                this.length = (end - start) / 2;
            }
        }
    }
    private PriorityQueue<Interval> pq;
    private int N;
    
    public ExamRoom(int N) {
        this.pq = new PriorityQueue<>((a, b) -> a.length != b.length ? b.length - a.length : a.start - b.start);
        this.N = N;
        pq.offer(new Interval(0, N - 1));
    }
    
    public int seat() {
        Interval in = pq.poll();
        int result;
        if (in.start == 0) {
            result = 0;
        } else if (in.end == N - 1) {
            result = N - 1;
        } else {
            result = in.start + in.length;
        }
        
        if (result > in.start) {
            pq.offer(new Interval(in.start, result - 1));   
        }
        if (in.end > result) {
            pq.offer(new Interval(result + 1, in.end));   
        }
        return result;
    }
    
    public void leave(int p) {
        List<Interval> list = new ArrayList(pq);
        Interval prev = null;
        Interval next = null;
        for (Interval in: list) {
            if (in.end + 1 == p) {
                prev = in;
            }
            if (in.start - 1 == p) {
                next = in;
            }
        }
        pq.remove(prev);
        pq.remove(next);
        pq.offer(new Interval(prev == null ? p : prev.start, next == null ? p : next.end));
        
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */