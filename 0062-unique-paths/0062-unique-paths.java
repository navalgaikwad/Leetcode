class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(m-1, n-1, new HashMap<>());
    }
    int dfs(int m, int n, HashMap<String, Integer> memo) {
        if(memo.containsKey(m+"-"+n)) return memo.get(m+"-"+n); 
        if(m == 0 && n == 0) {
            return 1;
        }
        if( m < 0 || n < 0) {
            return 0;
        }
        int down  = dfs(m - 1, n, memo);
        int right = dfs(m, n-1, memo);
        
        int result = down + right;
        memo.put(m+"-"+n, result);
        return result;
    }
}