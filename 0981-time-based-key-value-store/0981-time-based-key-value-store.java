class TimeMap {
    //key:[{1, naval}]
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
           map.put(key, new TreeMap<>()); 
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
           return ""; 
        }
        TreeMap<Integer, String> timeMap = map.get(key);
        Integer closestTime = timeMap.floorKey(timestamp);
        if(closestTime != null){
            return timeMap.get(closestTime);
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