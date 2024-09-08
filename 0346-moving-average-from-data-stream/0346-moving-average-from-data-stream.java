class MovingAverage {
    Queue<Double> queue = new LinkedList<>();
    int k;
    double sum = 0;
    public MovingAverage(int size) {
        this.k = size;
    }
    
    public double next(int val) {
        queue.add((double)val);
        sum = sum + val;
        while(queue.size() > k){
            sum = sum - queue.peek();
            queue.poll();
        }
        return sum/queue.size();
      
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */