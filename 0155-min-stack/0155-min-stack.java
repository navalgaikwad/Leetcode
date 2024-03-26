class MinStack {
    Stack<Integer>minStack = new Stack<>();
    Stack<Integer>stack = new Stack<>();
    public MinStack() {
        
    }

    public void push(int val) {
         stack.push(val);
        if(!minStack.isEmpty()){
            int min= minStack.peek();
            if(val<= min){
                  minStack.push(val);
            }
          
        }else{
            minStack.push(val);
        }
       
    }
    
    public void pop() {
         int val = stack.pop();
        if(val == minStack.peek()) {
            minStack.pop();
        }
       // stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */