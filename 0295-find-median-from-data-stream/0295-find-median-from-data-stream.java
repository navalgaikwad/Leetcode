class MedianFinder {

    //PriorityQueue<Double> maxHeap = new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
    PriorityQueue<Double> minHeap = new PriorityQueue<>();
   
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add((double)num);
         } else {
            minHeap.add((double)num);
        }
        
        // minHeap.add(Double. valueOf(num));
        // int size1 = maxHeap.size();
        // int size2 = minHeap.size();
        // if( size2 -size1 > 1 ){
        //    maxHeap.add(minHeap.remove()); 
        // }
        
             // Balance the heaps if necessary
        if(maxHeap.size() > minHeap.size() + 1){
           minHeap.add(maxHeap.remove());
        } else if(minHeap.size() > maxHeap.size()){
           maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        int size1 = maxHeap.size();
        int size2 = minHeap.size();
        if(size1 == size2){
           double max = maxHeap.peek();
           double min = minHeap.peek();
            double val = (max + min)/2;
            return val;
        }
       return maxHeap.peek();
       // return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */