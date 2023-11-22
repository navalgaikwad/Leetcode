import java.util.*;

class TimeMap {
    Map<String, TreeMap<Integer, String>> timemap;

    public TimeMap() {
        timemap = new HashMap<>();
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
        TreeMap<Integer, String> map = timemap.get(key);
        Integer closestTimestamp = map.floorKey(timestamp);
        if (closestTimestamp != null) {
            return map.get(closestTimestamp);
        }
        return "";
    }
}
