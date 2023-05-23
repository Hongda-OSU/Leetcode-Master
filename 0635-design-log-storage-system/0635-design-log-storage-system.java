class LogSystem {
    private Map<Integer, String> map;

    public LogSystem() {
        map = new HashMap<>();
    }
    
    public void put(int id, String timestamp) {
        map.put(id, timestamp);      
    }
    
    public List<Integer> retrieve(String start, String end, String granularity) {
        int x = 0;
        switch (granularity) {
            case "Year" -> x = 4;
            case "Month" -> x = 7;
            case "Day" -> x = 10;
            case "Hour" -> x = 13;
            case "Minute" -> x = 16;
            case "Second" -> x = 19;
        }
        start = start.substring(0, x);
        end = end.substring(0, x);
        List<Integer> result = new ArrayList<>();
        for (Integer i : map.keySet()) {
            String str = map.get(i).substring(0, x);
            if (str.compareTo(start) >= 0 && str.compareTo(end) <= 0)
                result.add(i);
        }
        return result;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */