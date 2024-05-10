class MedianFinder {
    PriorityQueue<Double> min = new PriorityQueue<>();
    PriorityQueue<Double> max = new PriorityQueue<>((a,b)->Double.compare(b,a));
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || num <= max.peek()) {
            max.add((double)num);
        }else {
            min.add((double)num);
        }
        
        if(max.size() > min.size() + 1) {
            min.add(max.remove());
        }else if(max.size() < min.size()) {
            max.add(min.remove());
        }
    }
    
    public double findMedian() {
        int s1 = max.size();
        int s2 = min.size();
        if(s1 == s2) {
           double ma = max.peek();
           double mi = min.peek();
            double val = (ma + mi)/2;
            return val; 
        }
        return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */