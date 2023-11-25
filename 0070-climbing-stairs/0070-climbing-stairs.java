class Solution {
    public int climbStairs(int n) {
        return helper(n, new HashMap<>());
    }
    int helper(int n, HashMap<Integer, Integer>memo){
        if(memo.containsKey(n)) return memo.get(n);
        if (n == 0 || n == 1) return 1;
        if(n<0) return 0;
       
        int total = helper(n-1, memo) + helper(n-2, memo); 
        memo.put(n, total);
        return total;
    }
}