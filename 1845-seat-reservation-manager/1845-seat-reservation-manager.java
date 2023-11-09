class SeatManager {
    List<Integer> ans = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    public SeatManager(int n) {
        ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            pq.offer(i);
        }
    }
    
    public int reserve() {
        return pq.remove();
    }
    
    public void unreserve(int seatNumber) {
         pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */