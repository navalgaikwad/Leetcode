class Solution {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount, new HashMap<>());
    }
    
    int dp(int[] coins, int target, HashMap<Integer, Integer> memo) {
        if(target == 0) {
            return 0;
        }
        if(target < 0) {
            return -1;
        }
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        
        Integer min = -1;
        for(int coin : coins) {
            int remainder = target - coin;
            int result = dp(coins, remainder, memo);
            if(result != -1) {
                int count = result + 1;
                if( min == -1 || count < min) {
                    min = count;
                }
            }
        }
        memo.put(target, min);
        return min;
    }
}