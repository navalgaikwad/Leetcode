import java.util.*;

class TimeMap {
    Map<String, TreeMap<Integer, String>> timemap;// took key and TreeMap<> with integer, String
    //one key can have multiple timestamp 
    //key :[{1, "naval"}]

    public TimeMap() {
        timemap = new HashMap<>();
        //key :[{1, "naval"},{2, "naval"},{3, "naval"}]
    }

    public void set(String key, String value, int timestamp) {
        if (!timemap.containsKey(key)) {
            timemap.put(key, new TreeMap<>());
        }
        TreeMap<Integer, String> map = timemap.get(key);
        map.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!timemap.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> map = timemap.get(key); // get the map
        Integer closestTimestamp = map.floorKey(timestamp);// get the time stamp from map if not found return empty 
        if (closestTimestamp != null) {
            return map.get(closestTimestamp);
        }
        return "";
    }
}
// one key can have multiple timestamp
//key :[{1, "naval"}].. correct
//timestamp:[key, value] ... wrong. work for some cases