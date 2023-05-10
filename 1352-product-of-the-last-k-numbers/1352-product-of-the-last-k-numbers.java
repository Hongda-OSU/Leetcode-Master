class ProductOfNumbers {
    private final List<Integer> list;
    private int lastProduct = 1;

    public ProductOfNumbers() {
        this.list = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
            lastProduct = 1;
        } else {
            lastProduct *= num;
            list.add(lastProduct);
        }
    }

    public int getProduct(int k) {
        final int index = list.size() - k;
        if (index > 0) return lastProduct / list.get(index - 1);
        if (index == 0) return lastProduct;

        return 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */