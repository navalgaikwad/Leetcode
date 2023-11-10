class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] result = new int[len];
        int j = 0;
        for(int i=0; i<len; i++){
            if(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    int top = stack.pop();
                    result[top] = i - top;
                }
            }
            stack.push(i);
            
        }
        return result;
    }
}