class BrowserHistory {
    TreeMap<Integer, String> map = new TreeMap<>();
    int ptr =0;
    public BrowserHistory(String homepage) {
        map.put(ptr, homepage);
    }
    
    public void visit(String url) {
        ptr++;
        map.put(ptr, url);
        map.tailMap(ptr+1).clear();
    }
    
    public String back(int steps) {
        ptr = Math.max(0, ptr - steps);
        return map.get(ptr);
    }
    
    public String forward(int steps) {
        ptr = Math.min(ptr + steps, map.lastKey());
        return map.get(ptr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */