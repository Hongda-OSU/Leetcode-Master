class SeatManager {
    private static PriorityQueue<Integer> pq;
    private int count;

    public SeatManager(int n) {
        this.count = 1;
        this.pq = new PriorityQueue<>();
    }
    
    public int reserve() {
        if (pq.size() == 0)
            return count++;
        return pq.poll();
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */