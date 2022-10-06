class TimeMap {
    static class Node {
        String value;
        int timestamp;
        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    HashMap<String, List<Node>> map;

    public TimeMap() {
        this.map = new HashMap<String, List<Node>>();
    }
    
    public void set(String key, String value, int timestamp) {
        Node node = new Node(value, timestamp);
        map.computeIfAbsent(key, t -> new ArrayList<Node>()).add(node);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        
        List<Node> store = map.get(key);
        int left = 0;
        int right = store.size()-1;
        while(left + 1 < right) {
            int mid = (left + right) >> 1;
            if(store.get(mid).timestamp < timestamp) {
                left = mid;
            } else if(store.get(mid).timestamp == timestamp){
                return store.get(mid).value;
            } else {
                right = mid;
            }
        }
        
        if(store.get(right).timestamp <= timestamp) {
            return store.get(right).value;
        } else if(store.get(left).timestamp <= timestamp){
            return store.get(left).value;
        }
        
        return "";
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */