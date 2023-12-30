class Solution {
    public int coinChange(int[] coins, int amount) {
        //HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
        HashMap<Integer, Integer> memo = new HashMap<>();
        Integer result = dp(coins, amount, memo);
        //System.out.print(result);
        //return result != null ? result.size() : -1;
        return result != null ? result : -1;
    }
    
    Integer dp(int[] coins, int target, HashMap<Integer, Integer> memo) {
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if(target == 0) {
            // ArrayList<Integer> baseList = new ArrayList<>();
            // return baseList;
            return 0;
        }
        if(target < 0) {
            return null;
        }
        //ArrayList<Integer> result = null;
        Integer result = null;
        for(int coin : coins) {
            int remainder = target - coin;
            Integer remainderList = dp(coins, remainder, memo);
            if(remainderList != null) {
                // ArrayList<Integer> combination = new ArrayList<>();
                // combination.addAll(remainderList);
                // combination.add(coin);
                int combination = remainderList + 1;
                
                if(result==null || combination < result) {
                    result = combination;
                }
            }
        }
        memo.put(target, result);
        return result;
    }
}