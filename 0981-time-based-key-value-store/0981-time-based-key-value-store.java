class TimeMap {
    HashMap<String, TreeMap<Integer, String>> keyTimeMap;

    public TimeMap() {
        keyTimeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key))
            keyTimeMap.put(key, new TreeMap<>());
        keyTimeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!keyTimeMap.containsKey(key))
            return "";
        Integer floorKey = keyTimeMap.get(key).floorKey(timestamp);
        if (floorKey != null) 
            return keyTimeMap.get(key).get(floorKey);
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */