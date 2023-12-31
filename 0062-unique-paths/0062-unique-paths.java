class Solution {
    public int uniquePaths(int m, int n) {
        return dp(m, n, new HashMap<>());
    }
    
    int dp(int m, int n, HashMap<String, Integer>memo) {
        String key = m+"-"+n;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(m == 1 && n == 1) {
            return 1;
        }
        if(m < 0 || n < 0) {
            return 0;
        }
        int result =  dp(m - 1, n, memo) + dp(m , n-1, memo);
        memo.put(key, result);
        return result;
        
    }
}