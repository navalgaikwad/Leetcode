class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer value = dp(coins, amount, new HashMap<>());
        return value == null ? -1 : value; 
    }
    
    Integer dp(int[] coins, int amount, HashMap<Integer, Integer> memo) {
        if(amount == 0) {
            return 0;
            
        }
        if(amount < 0) {
            return null;
        }
        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }
        Integer maxAmount = null;
        for(int coin : coins) {
            int remainder = amount - coin;
            if(remainder <= amount) {
                Integer count = dp(coins, remainder, memo);
                if(count!=null) {
                     int newCount = count + 1;
                    if(maxAmount == null || newCount <= maxAmount) {
                        maxAmount = newCount;
                    }
                }
            }
        }
        memo.put(amount, maxAmount);
        return maxAmount;
    }
}