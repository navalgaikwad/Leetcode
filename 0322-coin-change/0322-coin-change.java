class Solution {
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount+1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<=amount; i++) {
            if(dp[i]!=Long.MAX_VALUE) {
                for(int coin : coins) {
                    if( i <= amount - coin) {
                        dp[i + coin] = Math.min(dp[i+coin], dp[i] + 1);
                    }
                }
            }
        }
        return dp[amount] > amount ? -1 : (int) dp[amount];
    }
}