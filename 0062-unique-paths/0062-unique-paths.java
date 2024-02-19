class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
       // return dfs(m-1, n-1, new HashMap<>());
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
        // for (int i = m-1; i >= 0; i--) {
        //     for (int j = 0; j < n; j++) {
        //         if (i - 1 >= 0 || j + 1 < n) {
        //             if (i - 1 >= 0) dp[i - 1][j] += dp[i][j];
        //             if (j + 1 < n) dp[i][j + 1] += dp[i][j];
        //         }
        //     }
        // }
        // int[][] dp = new int[m][n];
        // dp[m-1][0] = 1;
        // for(int i = m-1; i>=0; i--) {
        //     for(int j=0; j<n; j++) {
        //         if(i-1 >=0) {
        //             dp[i-1][j] += dp[i][j];
        //         }
        //         if(j + 1 < n) {
        //             dp[i][j+1] += dp[i][j];
        //         }
        //     }
        // }
        // return dp[0][n-1];
        dp[m-1][0] = 1;
         for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m || j - 1 >= 0) {
                    if (i + 1 < m) dp[i][j] = dp[i][j] + dp[i + 1][j];
                    if (j - 1 >= 0) dp[i][j] = dp[i][j]+ dp[i][j - 1];
                    //grid chi value
                }
            }
        }
        return dp[0][n-1];
        
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