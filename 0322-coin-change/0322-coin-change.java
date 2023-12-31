class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer result = dp(coins, amount, new HashMap<>());
        return result == null ? -1 : result;  
    }
    Integer dp(int[] coins, int target, HashMap<Integer, Integer> memo){
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if(target == 0) {
            return 0;
        }
        if(target < 0) {
            return null;
        }
        Integer shortest = null;
        for(int coin : coins) {
            int remainder = target - coin;
            Integer remainderList = dp(coins, remainder, memo);
            if(remainderList != null) {
                Integer combination = remainderList + 1;
                if(shortest == null || combination < shortest) {
                    shortest = combination;
                }
            }
        }
        memo.put(target, shortest);
        return shortest;
    }
}