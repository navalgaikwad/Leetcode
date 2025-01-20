class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0; i<prices.length; i++) {
            if(i > 0 && prices[i] > prices[i-1]) {
                profit+= (prices[i] - prices[i-1]);
            
            }
        }
        return profit;
    }
}