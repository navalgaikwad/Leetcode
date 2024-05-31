class MinStack {
Stack<Integer> mainStack;
Stack<Integer> minStack;
//int min =0;
​
public MinStack() {
mainStack=new Stack<Integer>();
minStack=new Stack<Integer>();
}
public void push(int val) {
mainStack.push(val);
​
if(!minStack.isEmpty()){
int min= minStack.peek();
if(val<= min){
minStack.push(val);
}
}else{
minStack.push(val);
}
​
}
public void pop() {
int val = mainStack.pop();
if(val == minStack.peek()){
minStack.pop();
}
}
public int top() {
return mainStack.peek();
}
public int getMin() {
return minStack.peek();
}
}
​
/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(val);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/