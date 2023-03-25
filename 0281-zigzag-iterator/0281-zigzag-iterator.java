public class ZigzagIterator {
    public Queue<Iterator> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty())
            queue.offer(v1.iterator());
        if (!v2.isEmpty())
            queue.offer(v2.iterator());
    }

    public int next() {
        Iterator iter = queue.poll();
        int result = (int)iter.next();
        if (iter.hasNext())
            queue.offer(iter);
        return result;
    }

    public boolean hasNext() {
        return queue.peek() != null;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */