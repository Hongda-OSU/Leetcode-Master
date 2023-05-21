class Vector2D {
    int indexList, indexEle;
    int[][] vec; 
    public Vector2D(int[][] v) {
        indexList = 0; //index of list in the vec
        indexEle = 0; // index of element in current list of vec
        vec = v;
    }
    
    public int next() {
        if(hasNext()) {
            int res = vec[indexList][indexEle];
            indexEle++;
            return res;
        }
        return -1;
    }
    
    public boolean hasNext() {
        while(indexList < vec.length){
            if(indexEle < vec[indexList].length)
                return true;
            else{
                indexList++;
                indexEle = 0;
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