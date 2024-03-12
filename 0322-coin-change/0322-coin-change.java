class Solution {
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount+1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<=amount; i++) {
            if(dp[i] != Long.MAX_VALUE) {
                for(int coin : coins) {
                    int next = i + coin;
                    if(i <= amount - coin) {
                        dp[next] = Math.min(dp[next], dp[i] + 1);
                    }
                }
            }
        }
        return (int)dp[amount];
    }
}