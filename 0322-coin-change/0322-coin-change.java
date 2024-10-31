class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer value = helper(coins, amount, new HashMap<>()) ;
        return value== null? -1 : value;
    }
    
    Integer helper(int[] coins, int target, HashMap<Integer, Integer> memo) {
        if(target == 0) return 0;
        if(target < 0) return null;
        if(memo.containsKey(target)) return memo.get(target);
        Integer min = null;
        for(int coin : coins) {
            int remainder = target - coin;
            Integer count = helper(coins, remainder, memo);
            if(count != null) {
                int newCount = count + 1;
                if(min == null || newCount < min) {
                    min = newCount;
                }
            }
        }
        memo.put(target, min);
        return min;
    }
}