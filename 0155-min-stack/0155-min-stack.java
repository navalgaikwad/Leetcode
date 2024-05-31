class MinStack {
    Stack<Integer>min = new Stack<>();
    Stack<Integer>stack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        int value = stack.peek();
        if(!min.isEmpty()  && value == min.peek()) {
            min.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
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