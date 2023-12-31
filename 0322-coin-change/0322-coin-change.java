class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer result = dp(coins, amount, new HashMap<>());
        return result;  
    }
    Integer dp(int[] coins, int target, HashMap<Integer, Integer> memo){
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
        for(int coin : coins) {
            int remainder = target - coin;
            Integer remainderList = dp(coins, remainder, memo);
            if(remainderList != -1) {
                Integer combination = remainderList + 1;
                if(shortest == -1 || combination < shortest) {
                    shortest = combination;
                }
            }
        }
        memo.put(target, shortest);
        return shortest;
    }
}