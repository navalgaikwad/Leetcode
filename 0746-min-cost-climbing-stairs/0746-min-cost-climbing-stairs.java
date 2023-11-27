class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return dp(cost, cost.length, new HashMap<Integer, Integer>());
    }
    
    int dp(int[] cost, int currentStep, HashMap<Integer, Integer> memo){
        if (memo.containsKey(currentStep)){
            return memo.get(currentStep);
        }
        
        if(currentStep <= 1){
            return 0;
        }
        
        int fromLast = dp(cost, currentStep - 1, memo) + cost[currentStep-1];
        int secondLast = dp(cost, currentStep - 2, memo) + cost[currentStep-2];
        int currentCost =  Math.min(fromLast, secondLast);
        
        memo.put(currentStep, currentCost);
        return currentCost;
    }
}
