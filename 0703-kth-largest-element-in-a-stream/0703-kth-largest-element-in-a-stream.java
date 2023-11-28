class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        for(int i =0 ;i< nums.length; i++){
            pq.add(nums[i]);
        }
       // pq.add(nums);
        this.k = k;
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k){
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */