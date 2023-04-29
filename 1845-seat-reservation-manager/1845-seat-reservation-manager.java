class SeatManager {

  TreeMap<Integer,Boolean> map;
    public SeatManager(int n) {
        map = new TreeMap<>();
        for(int i = 1;i<=n;i++)
            map.put(i,true);
    }

    public int reserve() {
        return map.pollFirstEntry().getKey();
    }

    public void unreserve(int seatNumber) {
        map.put(seatNumber,true);
}
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */