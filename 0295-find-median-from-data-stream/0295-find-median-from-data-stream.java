class MedianFinder {
    public PriorityQueue<Integer> min;
    public PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size())
            max.offer(min.poll());
    } 
    
    public double findMedian() {
        if (max.size() == min.size())
            return (max.peek() + min.peek()) / 2.0;
        return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */