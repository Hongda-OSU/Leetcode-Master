class ExamRoom {
    private PriorityQueue<Interval> pq;
    private int n;

    public ExamRoom(int n) {
        pq = new PriorityQueue<>((a, b) -> a.length != b.length ? b.length - a.length : a.start - b.start);
        this.n = n;
        pq.offer(new Interval(0, n - 1, n));
    }
    
    public int seat() {
        Interval in = pq.poll();
        int result;
        if (in.start == 0)
            result = 0;
        else if (in.end == n - 1)
            result = n - 1;
        else 
            result = in.start + in.length;
        if (result > in.start) 
            pq.offer(new Interval(in.start, result - 1, n));
        if (in.end > result) 
            pq.offer(new Interval(result + 1, in.end, n));
        return result;
    }
    
    public void leave(int p) {
        List<Interval> list = new ArrayList<>(pq);
        Interval prev = null, next = null;
        for (Interval in : list) {
            if (in.end + 1 == p)
                prev = in;
            if (in.start - 1 == p)
                next = in;
        }
        pq.remove(prev);
        pq.remove(next);
        pq.offer(new Interval(prev == null ? p : prev.start, next == null ? p : next.end, n));
    }
}

class Interval {
    public int start, end, length;
    
    public Interval(int start, int end, int n) {
        this.start = start;
        this.end = end;
        if (start == 0 || end == n - 1) 
            this.length = end - start;
        else
            this.length = (end - start) / 2;
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */