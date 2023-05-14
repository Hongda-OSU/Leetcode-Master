class FreqStack {
    private Map<Integer, LinkedList<Integer>> st;
    private Map<Integer, Integer> map;
    private int maxFreq;

    public FreqStack() {
        st = new HashMap<>();
        map = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int currFreq = map.getOrDefault(val, 0);
        currFreq++;
        map.put(val, currFreq);
        if (st.containsKey(currFreq) == false) 
            st.put(currFreq, new LinkedList<>());
        st.get(currFreq).addFirst(val);
        maxFreq = Math.max(maxFreq, currFreq);
    }
    
    public int pop() {
        int result = st.get(maxFreq).removeFirst();
        int currFreq = map.get(result);
        currFreq--;
        map.put(result, currFreq);
        if (st.get(maxFreq).size() == 0)
            maxFreq--;
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */