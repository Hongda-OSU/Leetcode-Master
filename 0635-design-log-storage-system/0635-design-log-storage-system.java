public class LogSystem {    
    TimeNode root;
        
    public LogSystem() {
        root = new TimeNode(null, -1);
    }
    
    public void put(int id, String timestamp) {
        int[] timeArr = convert(timestamp);
        root.add(timeArr, 0, id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<Integer>(300);
        int graIdx = getGraIndex(gra);
        int[] start = convert(s);
        int[] end = convert(e);
        end[graIdx]++;
        TimeNode startNode = root.getTimeNode(start, 0, graIdx);
        TimeNode endNode = root.getTimeNode(end, 0, graIdx);
        TimeNode node = startNode;
        while(node !=null && node !=  endNode){
            res.add(node.id);
            node = node.nextSecNode();
        }
        return res;
    }
    
    private int[] convert(String timestamp){
        String[] timeStrs = timestamp.split(":");
        int[] timeDigits = new int[timeStrs.length];
        for(int i=0; i<timeStrs.length; i++){
            timeDigits[i]=Integer.valueOf(timeStrs[i]);
        }
        return timeDigits;
    }
    
    private int getGraIndex(String gra){
        switch(gra){
            case "Year":
                return 0;
            case "Month":
                return 1;
            case "Day":
                return 2;
            case "Hour":
                return 3;
            case "Minute":
                return 4;
            case "Second":
                return 5;
        }
        return -1;       
    }
    
    class TimeNode{
        TimeNode parent; 
        TreeMap<Integer, TimeNode> children;
        int key;
        int id=-1;
        
        public TimeNode(TimeNode parent, int key){
            this.parent = parent;
            this.key = key;
            children = new TreeMap<>();
        }
        
        public void add(int[] time, int i, int id){
            if(i==time.length){
                this.id = id;
                return;
            }
            TimeNode node = children.get(time[i]);
            if(node == null){
                node = new TimeNode(this, time[i]);
                children.put(time[i], node);
            }
            node.add(time, i+1, id);
        }
        //the Time second node which is >= given time
        public TimeNode getTimeNode(int[] time, int i, int graLevel){
            if(i==graLevel+1){
                return this.getFirstSecNode();
            }
            if(children.containsKey(time[i])){
                return children.get(time[i]).getTimeNode(time, i+1, graLevel);
            }
            TimeNode nextSibling = getNextSibling(time[i]);
            if(nextSibling != null) return nextSibling.getFirstSecNode();
            else return nextSecNode();
        }
           
        public TimeNode nextSecNode(){
            TimeNode node = this;
            TimeNode nextSibling = null;
            while (node.parent != null ){
                nextSibling = node.parent.getNextSibling(node.key);
                if (nextSibling != null) break;
                node = node.parent;
            }
            return nextSibling == null? null : nextSibling.getFirstSecNode();
        }
        
        //For any node in the tree, return the first node represent Second
        private TimeNode getFirstSecNode(){
            TimeNode node = this;
            while(!node.children.isEmpty()){
                Integer firstKey=node.children.firstKey();
                node = node.children.get(firstKey);
            }
            return node;
        }
        
        private TimeNode getNextSibling(int key){
            Integer nextSiblingIdx = children.ceilingKey(key+1);
            if (nextSiblingIdx == null)  return null;
            return children.get(nextSiblingIdx);
        }
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */