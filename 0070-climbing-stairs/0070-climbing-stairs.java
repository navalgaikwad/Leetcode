class Solution {
    public int climbStairs(int n) {
        return dp(n, new HashMap<>());
    }
    
    int dp(int i, HashMap<Integer, Integer> memo) {
        if(i == 0 || i==1) {
            return 1;
        }
        if(i< 0) {
            return 0;
        }
        if(memo.containsKey(i)) {
            return memo.get(i);
        }
        int total = dp(i-1, memo) + dp(i-2, memo) ;
        memo.put(i, total);
        return total;
    }
}