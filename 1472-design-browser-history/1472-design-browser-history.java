class BrowserHistory {
    TreeMap<Integer, String> map;
    int ptr =0;
    int homePtr =0;
    public BrowserHistory(String homepage) {
        map = new TreeMap<>();
        map.put(ptr, homepage);
        //ptr++;
    }
    
    public void visit(String url) {
        ptr++;
        map.put(ptr, url); //leet,go,fb, yt
        map.tailMap(ptr + 1).clear();
    }
    
    public String back(int steps) {
       
            ptr = Math.max(ptr - (steps), 0);
        
//             if(ptr <0){
//             ptr = 0;
//             }
           return map.get(ptr);
    }
    
    public String forward(int steps) { // adding can beyond the size so add the condition ptr > map.size()
        
             ptr = Math.min(ptr + steps, map.lastKey());
            
            // if(ptr > map.size()){
            //   ptr = map.lastKey();
            // }
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