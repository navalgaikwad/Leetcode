class MedianFinder {
    PriorityQueue<Double> max = new PriorityQueue<>((a, b) -> Double.compare(b, a));
    PriorityQueue<Double> min = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
      if(max.isEmpty() || num < max.peek()) {
          max.add((double)num);
      }else {
          min.add((double) num);
      }
        
        if(max.size() > min.size()+1) {
            min.add(max.remove());
        }else if(max.size() < min.size()) {
            max.add(min.remove());
        }
    }
    
    public double findMedian() {
        int size1 = max.size();
        int size2 = min.size();
        if(size1 == size2) {
            double maxKey = max.peek();
            double minKey = min.peek();
            return (maxKey+minKey)/2;
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