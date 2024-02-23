class RecentCounter {
     Queue<Integer> pq = new LinkedList<>();
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        pq.add(t);
        while(!pq.isEmpty() && t - pq.peek() > 3000) {
            pq.remove();
        }
        return pq.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */