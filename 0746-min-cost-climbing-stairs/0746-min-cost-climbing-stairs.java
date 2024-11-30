class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
	Integer[] dp = new Integer[n];
	return Math.min(dp(cost, n-1, dp), dp(cost, n-2, dp));
    }
    
    int dp(int[] cost, int i, Integer[] memo) {
        if(i < 0) return 0; 
        if(i == 0 || i == 1) {
            return cost[i];
        }
        if(memo[i]!=null) return memo[i];
        
        int oneStep = dp(cost, i - 1, memo);
        int twoStep = dp(cost, i - 2, memo);
        int value = cost[i] + Math.min(oneStep, twoStep);
        memo[i] = value;
        return value;
    }
}