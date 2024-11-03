public class Solution {
  public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 0; i <= amount; i++) {
        if(dp[i] != max) {
            
        
      for (int coin : coins) {
        if ( i <= amount - coin) {
          dp[i + coin] = Math.min(dp[i] + 1, dp[i + coin] );
        }
      }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}