class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m, n, new HashMap<>());
    }
    
    int helper(int m, int n, Map<String, Integer> memo){
        String key = m+"-"+n;
        if(memo.containsKey(key)) return memo.get(key);
        if(m == 1 && n == 1) return 1;
        if(m == 0 || n == 0) return 0;
        
        int first = helper(m - 1, n, memo);
        int second = helper(m, n-1, memo);
        
        memo.put(key, first+second);
        return memo.get(key);
    }
}