class CustomStack {
    int[] data;
    int ptr = 0;
    int maxSize;
    public CustomStack(int _maxSize) {
        data = new int[_maxSize];
        this.maxSize = _maxSize;
    }
    
    public void push(int x) {
        if(ptr == maxSize) return;
        data[ptr++] = x;
    }
    
    public int pop() {
        if(ptr == 0){
            return -1;
        }
        return data[--ptr];
    }
    
    public void increment(int k, int val) {
        if(ptr < k){
           for( int i=0; i<maxSize; i++){
               data[i] = data[i]+val;
           } 
        }else{
            for(int i=0; i<k ;i++){
                data[i]=data[i]+val;
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */