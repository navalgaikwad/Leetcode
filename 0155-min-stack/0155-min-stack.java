class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= min ){
            minStack.push(val);
            min = val;
        }
    }
    
    // public void pop() {
    //     if(minStack.peek()==stack.peek()){
    //         minStack.pop();
    //         min = getMin();
    //     }
    //     stack.pop();
    // }
    public void pop() {
    if (stack.peek().equals(minStack.peek())) {
        minStack.pop();
        if (!minStack.isEmpty()) {
            min = minStack.peek();
        } else {
            min = Integer.MAX_VALUE; // No minimum value in the stack
        }
    }
    stack.pop();
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