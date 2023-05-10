class ProductOfNumbers {
    private List<Integer> list;
    private int lastProduct;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        lastProduct = 1;
    }
    
    public void add(int num) {
        if (num == 0) {
            list = new ArrayList<>();
            lastProduct = 1;
        } else {
            lastProduct *= num;
            list.add(lastProduct);
        }
    }
    
    public int getProduct(int k) {
        int index = list.size() - k;
        if (index > 0)
            return lastProduct / list.get(index - 1);
        if (index == 0)
            return lastProduct;
        return 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */