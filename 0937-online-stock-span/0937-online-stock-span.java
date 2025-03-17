class StockSpanner {
    Stack<int[]> arr = new Stack<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int ans = 1;
        while(!arr.isEmpty() && arr.peek()[0] <= price) {
            ans+=arr.pop()[1];
        }
        arr.push(new int[]{price, ans});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */