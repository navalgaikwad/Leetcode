class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice1 = 0;
        int minPrice2 = Integer.MAX_VALUE;
        int maxPrice2 = 0;
        for(int i =0; i<prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxPrice1 = Math.max(maxPrice1, prices[i] - minPrice);
            
            minPrice2 = Math.min(minPrice2,  prices[i] - maxPrice1);
            maxPrice2 = Math.max(maxPrice2, prices[i] - minPrice2);
        }
        return maxPrice2;
    }
}