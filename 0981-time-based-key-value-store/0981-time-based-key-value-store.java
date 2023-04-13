class TimeMap {
    private Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Node> nodes = map.get(key);
        if (nodes == null)
            return "";
        int left = 0, right = nodes.size() - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            Node node = nodes.get(mid);
            if (node.timestamp == timestamp) 
                return node.value;
            else if (node.timestamp < timestamp) 
                left = mid;
            else 
                right = mid;
        }
        if (nodes.get(right).timestamp <= timestamp)
            return nodes.get(right).value;
        else if (nodes.get(left).timestamp <= timestamp)
            return nodes.get(left).value;
        return "";
    }
}

class Node {
    public String value;
    public int timestamp;
    
    public Node(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */