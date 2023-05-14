class MedianFinder {
    private PriorityQueue<Integer> min, max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        if (min.isEmpty() && max.isEmpty())
            max.add(num);
        else if (num > max.peek()) {
            min.add(num);
            if (min.size() - max.size() >= 2)
                max.add(min.poll());
        } else {
            max.add(num);
            if (max.size() - min.size() >= 2)
                min.add(max.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() == min.size()) {
            double result = (double)max.peek() + (double)min.peek();
            result = result / (double)2;
            return result;
        }
        if (min.size() > max.size())
            return (double)min.peek();
        return (double)max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */