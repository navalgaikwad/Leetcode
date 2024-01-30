class Solution {
    public int uniquePaths(int m, int n) {
        return dp(m-1, n-1, new HashMap<>());
    }
    int dp(int m, int n, HashMap<String, Integer> memo) {
        String key = m+"-"+n;
        if(m == 0 && n ==0) {
            return 1;
        } 
        if(m < 0 || n < 0) {
            return 0;
        } 
        if(memo.containsKey(key)) return memo.get(key);
        int left = dp(m -1, n, memo);
        int right = dp(m, n-1, memo);
        
        int result = left + right;
        memo.put(key, result);
        return result;
    }
}