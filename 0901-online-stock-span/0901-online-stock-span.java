class StockSpanner {

List<Integer> list; int i;

    public StockSpanner() {
        list = new ArrayList<Integer>();
        i = 0;
    }
    
    public int next(int price) {
        list.add(i, price); 
        int j=i; int count = 0;
        while(list.get(j) <= price){
            if(j==0) {
                count++;
                break;
            }
            else{
                count++; 
                j--;
            }
        }
        i++;
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */