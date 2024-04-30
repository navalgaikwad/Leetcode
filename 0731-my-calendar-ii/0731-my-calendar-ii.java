class MyCalendarTwo {

    public MyCalendarTwo() {
        
    }
    
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    public boolean book(int s, int e) {
        map.put(s, map.getOrDefault(s, 0) + 1); 
        map.put(e, map.getOrDefault(e, 0) - 1); 
		
        int sum = 0, max = 0;
        for (int v : map.values()) { 
            sum += v;
            max = Math.max(max, sum);
            if (max > 2) { 
                map.put(s, map.get(s) - 1); 
                map.put(e, map.get(e) + 1); 
                return false; 
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

