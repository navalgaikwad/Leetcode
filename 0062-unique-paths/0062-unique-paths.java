class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m ][n];
        dp[m - 1][0] = 1;

        // for (int i = m-1; i >= 0; i--) {
        //     for (int j = 0; j < n; j++) {
        //         if (i - 1 >= 0 || j + 1 < n) {
        //             if (i - 1 >= 0) dp[i - 1][j] += dp[i][j];
        //             if (j + 1 < n) dp[i][j + 1] += dp[i][j];
        //         }
        //     }
        // }
        
        for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m || j - 1 >= 0) {
                    if (i + 1 < m) dp[i][j] = dp[i][j] + dp[i + 1][j];
                    if (j - 1 >= 0) dp[i][j] = dp[i][j]+ dp[i][j - 1];
                    //grid chi value
                }
            }
        }

        // Print the array for debugging
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[0][n -1];
    }
}


// class Solution {
//     public int uniquePaths(int m, int n) {
//         Integer[][] memo = new Integer[m][n];
//         return memoDP(m - 1, 0, m, n, memo);
//     }

//     private int memoDP(int i, int j, int m, int n, Integer[][] memo) {
//         if (i == 0 && j == n - 1) {
//             return 1;
//         }
//         if (i < 0 || j >= n) {
//             return 0;
//         }
//         if (memo[i][j] != null) {
//             return memo[i][j];
//         }
//         int left = memoDP(i - 1, j, m, n, memo);
//         int up = memoDP(i, j + 1, m, n, memo);
//         memo[i][j] = left + up;
//         return memo[i][j];
//     }
// }
