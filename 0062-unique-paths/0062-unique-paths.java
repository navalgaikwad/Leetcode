class Solution {
    public int uniquePaths(int m, int n) {
        return dp(m - 1, n -1, new HashMap<>());
    }
    
    int dp(int m, int n, HashMap<String, Integer> memo) {
        String key = m+"-"+n;
        if(m == 0 && n == 0) {
            return 1;
        }
        if(m < 0 || n < 0) {
            return 0;
        }
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int one  = dp(m - 1, n, memo);
        int two = dp(m, n-1, memo);
        int answer = one + two;
        memo.put(key, answer);
        return answer;
    }
}