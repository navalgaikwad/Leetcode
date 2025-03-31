class MedianFinder {
    PriorityQueue<Double> minHeap = new PriorityQueue<>();
    PriorityQueue<Double> maxHeap = new PriorityQueue<>((a,b)->Double.compare(b,a));
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {//vvimp num < maxheap
            maxHeap.add((double)num);
        }else {
            minHeap.add((double)num);
        }
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add((double)maxHeap.remove());
        }else if(maxHeap.size() < minHeap.size()){
            maxHeap.add((double)minHeap.remove());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            double min = minHeap.peek();
            double max = maxHeap.peek();
            return (min+max)/2;
        }
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */