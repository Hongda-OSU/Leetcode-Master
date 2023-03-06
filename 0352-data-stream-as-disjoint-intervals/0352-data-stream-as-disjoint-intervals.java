class SummaryRanges {
    public TreeSet<int[]> set;

    public SummaryRanges() {
        set = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    }
    
    public void addNum(int value) {
        int[] interval = new int[]{value, value};
        if (set.contains(interval))
            return;
        int[] high = set.higher(interval);
        int[] low = set.lower(interval);
        if (high != null && high[0] == value + 1 && low != null && low[1] == value - 1) {
            high[0] = low[0];
            set.remove(low);
        } else if (high != null && high[0] == value + 1) {
            high[0]--;
        } else if (low != null && low[1] == value - 1) {
            low[1]++;
        } else if((high != null && high[0] == value) || (low != null && low[1] >= value && low[0] <= value)) {
            return;
        } else {
            set.add(interval);
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : set) 
            list.add(interval);
        return list.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */