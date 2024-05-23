class Solution {
    public int uniquePaths(int m, int n) {
        //return helper(m-1, n - 1, new HashMap<>());
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=0; i<m; i++) {
            for(int j =0; j<n; j++) {
                if(i-1 >=0) {
                  dp[i][j] += dp[i-1][j];
                }
                 if(j-1 >=0) {
                  dp[i][j] += dp[i][j-1];
                }
            }
        }
    
        return dp[m-1][n-1];
    }
    
    
     // int[][] dp = new int[m+1][n+1];
        // dp[0][0] = 1;
        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         if(i - 1 >= 0 ) {
        //             dp[i][j] += dp[i-1][j];
        //         }
        //         if(j - 1 >= 0) {
        //             dp[i][j] += dp[i][j-1];
        //         }
        //     }
        // }
        // return dp[m-1][n-1];
    /*
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
    */
}