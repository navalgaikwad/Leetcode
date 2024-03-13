class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m-1, n - 1, new HashMap<>());
    }
    
    int helper(int m, int n, HashMap<String, Integer> memo) {
        String key = m+"-"+n;
        if( m== 0 && n == 0) {
            return 1;
        }
        if( m < 0 || n < 0) {
            return 0;
        }
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int one = helper(m - 1, n, memo);
        int two = helper(m, n - 1, memo);
        int total = one + two;
        memo.put(key, total);
        return total;
    }
}