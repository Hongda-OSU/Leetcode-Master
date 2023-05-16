public class ZigzagIterator {
    private List<List<Integer>> vectors = new ArrayList<>();
    // pointer to vector, and pointer to element
    private Integer pVec = 0, pElem = 0;
    private Integer totalNum = 0, outputCount = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.vectors.add(v1);
        this.vectors.add(v2);
        for (List<Integer> vec : this.vectors) {
            this.totalNum += vec.size();
        }
    }

    public int next() {
        Integer iterNum = 0, ret = null;
        while (iterNum < this.vectors.size()) {
            List<Integer> currVec = this.vectors.get(this.pVec);
            if (this.pElem < currVec.size()) {
                ret = currVec.get(this.pElem);
                this.outputCount += 1;
            }

            iterNum += 1;
            this.pVec = (this.pVec + 1) % this.vectors.size();
            // increment the element pointer once iterating all vectors
            if (this.pVec == 0)
                this.pElem += 1;

            if (ret != null)
                return ret;
        }
        // one should raise an exception here.
        return 0;
    }

    public boolean hasNext() {
        return this.outputCount < this.totalNum;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such: ZigzagIterator i = new
 * ZigzagIterator(v1, v2); while (i.hasNext()) v[f()] = i.next();
 */
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */