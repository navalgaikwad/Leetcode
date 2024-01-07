class RecentCounter {
    Queue<Integer> q = new LinkedList<>();
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        q.add(t);
        while (!q.isEmpty() && t - q.peek() > 3000) {
            q.poll();
        }
        //q.add(t);
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */