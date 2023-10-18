class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int price: prices){
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }
}


