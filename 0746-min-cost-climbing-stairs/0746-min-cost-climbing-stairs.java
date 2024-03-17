class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        int costToReachEnd = Integer.MAX_VALUE;
        for(int i =2; i<=cost.length; i++){
            int fromLast = dp[i-2] + cost[i-2]; //one step from postion behind
            int secondLast = dp[i-1] + cost[i-1]; // two step from behind
            costToReachEnd = Math.min(fromLast, secondLast);
            dp[i] = costToReachEnd;
            
        }
        return dp[cost.length];
    }
}