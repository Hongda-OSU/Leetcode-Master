class ProductOfNumbers {
    ArrayList<Integer> pList;
    
    public ProductOfNumbers() {
        pList = new ArrayList<Integer>();
    }
    
    public void add(int num) {
        if (num == 0) pList.clear();
        else 
            pList.add(pList.size() == 0 ? num : pList.get(pList.size() - 1)*num);
    }
    
    public int getProduct(int k) {
        if (k > pList.size()) return 0;
        if (k == pList.size()) return pList.get(pList.size()-1);
        return pList.get(pList.size()-1)/pList.get(pList.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */