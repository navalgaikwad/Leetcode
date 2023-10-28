class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       int[][] dp = new int[ n+1 ][ 2 ];
       for(int  i = n -1; i>=0; i--){
           for(int buy = 0; buy<=1; buy++){
               if(dp[i][buy]!=0){
                   return dp[i][buy];
               }
               if(buy == 1){
                   dp[i][buy] = Math.max( -prices[i] + dp[i+1][0],
                                         0 + dp[i+1][1]);
               }else{
                   dp[i][buy] = Math.max( prices[i] + dp[i+1][1],
                                         0 + dp[i+1][0]);  
               }
           }
       }
         
        return dp[0][1];
        
    }
}


