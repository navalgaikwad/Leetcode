class Solution {
    public int maxProfit(int[] prices) {
        int i=0,j=1;
        int max=0;
        while(j<prices.length){
            if(prices[j]<prices[i]){
                i=j;
                j++;
            }
            else{
            max=Math.max(max,prices[j]-prices[i]);
            j++;
            }
        }
        return max;
    }
}