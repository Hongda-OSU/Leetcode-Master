class StockSpanner {
    
    class Pair {
        int price;
        int index;
        
        Pair(Integer price , Integer index){
            this.price = price;
            this.index = index;
        }
    }
    
    Stack<Pair> st = new Stack<>(); ;
    int index = -1;
    
    public StockSpanner() {
        // st = new Stack<>();
    }
    
    public int next(int price) {
        index++;
        Pair pair = new Pair(price , index);
        while(!st.isEmpty() && price >= st.peek().price) {
				st.pop();
			}
		if(st.isEmpty()) {
            st.push(pair);
			return index + 1;
		}else {
			int prevHigh = st.peek().index;	
            st.push(pair);
			return index - prevHigh;
		}
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */