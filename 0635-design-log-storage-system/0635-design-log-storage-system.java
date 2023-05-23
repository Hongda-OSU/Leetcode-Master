public class LogSystem {
    Map<Integer,String> map=new HashMap<>();
    public LogSystem() {
        
    }
    
    public void put(int id, String timestamp) {
        map.put(id,timestamp);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        int x=0;
        switch (gra){
            case "Year":
                x=4; 
                break;
            case "Month":
                x=7;
                break;
            case "Day":
                x=10;
                break;
            case "Hour":
                x=13;
                break;
            case "Minute":
                x=16;
                break;
            case "Second":
                x=19;
                break;
        }
        s=s.substring(0,x);
        e=e.substring(0,x);
        List<Integer> ans=new ArrayList<>();
        for (Integer i:map.keySet())
        {
            String ss=map.get(i).substring(0,x);
            if (ss.compareTo(s)>=0 && ss.compareTo(e)<=0) ans.add(i);
        }
        return ans;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */