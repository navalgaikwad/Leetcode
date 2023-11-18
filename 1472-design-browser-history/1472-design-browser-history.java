import java.util.TreeMap;

class BrowserHistory {
    TreeMap<Integer, String> map;
    int ptr;

    public BrowserHistory(String homepage) {
        map = new TreeMap<>();
        ptr = 0;
        map.put(ptr, homepage);
    }

    public void visit(String url) {
        ptr++;
        map.put(ptr, url);
        map.tailMap(ptr + 1).clear();
    }

    public String back(int steps) {
        ptr = Math.max(0, ptr - steps);
        return map.get(ptr);
    }

    public String forward(int steps) {
        ptr = Math.min(map.lastKey(), ptr + steps);
        return map.get(ptr);
    }
}
