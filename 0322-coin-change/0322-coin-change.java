class Solution {
    //O(N∗Amount) //O(Amount)
    public int coinChange(int[] coins, int amount) {
        Integer result =  helper(coins, amount, new HashMap<>());
        return result != null ? result : -1;
        
    }

    Integer helper(int[] coins, int amount, Map<Integer, Integer> memo) {
        if(amount < 0) {
            return null;
        }
        if(amount ==0) {
            return 0;
        }
        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }
        Integer total = null;
        for(int coin : coins) {
            Integer remainder = helper(coins, amount - coin, memo);
            if(remainder != null) {
                int count = remainder + 1;
                if(total == null || count < total) {
                    total = count;
                }
            }
        }
        memo.put(amount, total);
        return total;
    }
}