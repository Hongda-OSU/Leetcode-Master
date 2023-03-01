class SnapshotArray {
    private HashMap<Integer, Integer>[] snapShotHistory;
    private int totalSnaps;
    private HashMap<Integer, Integer> snaps;

    public SnapshotArray(int length) {
        snaps = new HashMap<>();
        snapShotHistory = new HashMap[length];
        for (int i = 0; i < length; i++) 
            snapShotHistory[i] = new HashMap<>();
    }
    
    public void set(int index, int val) {
        snaps.put(index, val);
    }
    
    public int snap() {
        for (int key : snaps.keySet()) {
            HashMap<Integer, Integer> snapShotHistoryIdx = snapShotHistory[key];
            snapShotHistoryIdx.put(totalSnaps, snaps.get(key));
        }
        snaps = new HashMap<>();
        totalSnaps++;
        return totalSnaps - 1;
    }
    
    public int get(int index, int snap_id) {
        while (snap_id >= 0) {
            if (snapShotHistory[index].containsKey(snap_id))
                return snapShotHistory[index].get(snap_id);
            snap_id--;
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */