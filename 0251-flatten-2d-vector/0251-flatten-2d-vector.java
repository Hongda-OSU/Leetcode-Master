class Vector2D {
    private int indexList, indexElement;
    private int[][] vec;

    public Vector2D(int[][] vec) {
        indexList = 0;
        indexElement = 0;
        this.vec = vec;
    }
    
    public int next() {
        if (hasNext()) {
            int result = vec[indexList][indexElement];
            indexElement++;
            return result;
        }
        return -1;
    }
    
    public boolean hasNext() {
        while (indexList < vec.length) {
            if (indexElement < vec[indexList].length)
                return true;
            else {
                indexList++;
                indexElement =0;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */