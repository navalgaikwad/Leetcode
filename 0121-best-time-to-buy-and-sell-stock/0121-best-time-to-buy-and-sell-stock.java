class Solution {
    public int maxProfit(int[] prices) {
        int mix = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for(int price : prices) {
            mix = Math.min(mix, price);
            max = Math.max(max, price - mix);
        }
        return max;
    }
}