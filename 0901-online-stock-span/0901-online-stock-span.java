class StockSpanner {
    Stack<int[]> decreasingStack;
    public StockSpanner() {
        decreasingStack = new Stack<>();
    }
    
    public int next(int price) {
        int ans = 1;
        //monotonic dcreasing stack
        while(decreasingStack.size() > 0 && decreasingStack.peek()[0] <= price){
            ans = ans + decreasingStack.pop()[1];
        }
        decreasingStack.push(new int[]{price, ans});
        return ans;
    }
}
//[70 - 1]
//[60- 1]-- remove() and 1 of 60 add it to [70 - 1] so it becomes [70 - 2] and pop 60
//[80 - 1]
//[100, 1]
///
    
    //so new combination
    //[75 - 4] 
    //[60 - 1]--
    //[70 - 2]--
    //[80 - 1]
    //[100, 1]

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

//[[], [100], [80], [60], [70], [60], [75], [85]]
//100  - 1
//80 - 1

// class StockSpanner {
//     Stack<int[]> stack = new Stack<>();
    
//     public int next(int price) {
//         int ans = 1;
//         while (!stack.isEmpty() && stack.peek()[0] <= price) {
//             ans += stack.pop()[1];
//         }
        
//         stack.push(new int[] {price, ans});
//         return ans;
//     }
// }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */