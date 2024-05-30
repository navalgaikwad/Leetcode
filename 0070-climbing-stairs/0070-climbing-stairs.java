class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];
        // dp[0] = 1;
        // dp[1] = 1;
        // for(int i = 2; i<=n; i++) {
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        return helper(n-1, new HashMap<>());
    }
    int helper(int i, HashMap<Integer, Integer> memo) {
        if( i == -1) {
            return 1;
        }
        if(i < -1) {
            return 0;
        }
        if(memo.containsKey(i)) {
            return memo.get(i);
        }
        int one = helper(i - 1, memo);
        int two = helper(i-2, memo);
        int total = one + two; 
        memo.put(i, total);
        return total;
    }
}