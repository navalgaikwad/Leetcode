class MedianFinder {
    PriorityQueue<Double> minHeap = new PriorityQueue<>();
    PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || (double) num <= maxHeap.peek()){
            maxHeap.add((double)num);
        }else{
            minHeap.add((double)num);
        }
        
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.remove());
        }else if(maxHeap.size() < minHeap.size()){
             maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        int size1 = maxHeap.size();
        int size2 = minHeap.size();
        if(size1 == size2) {
           double max = maxHeap.peek();
           double min = minHeap.peek();
            double val = (max + min)/2;
            return val;
        }
       return maxHeap.peek();
    }
}