class Solution {
    public int coinChange(int[] coins, int amount) {
         Integer value = dp(coins, amount, new HashMap<>());
        return value == null? -1 : value;
    }
    Integer dp(int[] coins, int target, Map<Integer, Integer> memo) {
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if(target == 0) {
            return 0;
        }
        if(target < 0) {
            return null;
        }
        Integer maxCount = null;
        for(int coin : coins) {
            int remainder = target - coin;
            Integer count = dp(coins, remainder, memo);
            
            if(count!= null) {
                int newCount = count + 1;
                if(maxCount == null || newCount <  maxCount) {
                    maxCount = newCount;
                }
            }
        }
        memo.put(target, maxCount);
        return maxCount;
    }
}