class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer result = dp(coins, amount, new HashMap<>());
        return result == null ? -1 : result;
    }
    
    Integer dp(int[] coins, int target, HashMap<Integer, Integer> memo) {
        if(target == 0) {
            return 0;
        }
        if(target < 0) {
            return null;
        }
        if(memo.containsKey(target)) {
            return memo.get(target);
        } 
        Integer shorter = null;
        for(int coin : coins) {
            Integer remainder = target - coin;
            Integer value = dp(coins, remainder, memo);
            if(value != null) {
                int count = value + 1;
                if(shorter == null || value < shorter) {
                    shorter = count;
                }
            }
        }
        memo.put(target, shorter);
        return shorter;
    }
}