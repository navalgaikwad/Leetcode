class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer value = dp(coins, amount, new HashMap<>());
        if(value!=null) return value;
        return -1;
    }
    Integer dp(int[] coins, int target, HashMap<Integer, Integer> memo) {
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if(target == 0) {
           // ArrayList<Integer> baseList = new ArrayList<>();
            return 0;
        }
        if(target < 0) {
            return null;
        }
        Integer result = null;
        for(int coin : coins) {
            int remainder = target - coin;
            Integer combinations = dp(coins, remainder, memo);
            if(combinations != null) {
                Integer newCombination = combinations + 1;
                if(result == null || newCombination < result) {
                    result = newCombination;
                }
            }
        }
        memo.put(target, result);
        return result;
    }
}