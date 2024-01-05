class Solution {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount, new HashMap<>());
    }
    
    Integer dp(int[] coins, int target, HashMap<Integer, Integer> memo) {
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if(target == 0) {
            return 0;
        }
        if(target < 0) {
            return -1;
        }
        Integer shortest = -1;
        for(int coin: coins) {
            int remainder = target - coin;
            int remainderList = dp(coins, remainder, memo);
            if(remainderList != -1) {
                Integer count = remainderList + 1;
                if(shortest == -1 || count < shortest) {
                    shortest = count;
                }
                
            }
        }
        memo.put(target, shortest);
        return shortest;
    }
}

