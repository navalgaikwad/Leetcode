class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
       // Arrays.fill(dp[], -1);
        dp[1][1] = 1;
        for(int i =1; i<=m; i++) {
            for(int j =1; j<=n; j++) {
                    if(i - 1 >=0) {
                        int prevI = dp[i-1][j] ;
                       dp[i][j] += prevI; 
                    }
                    if(j - 1 >= 0) {
                       int prevJ = dp[i][j-1];
                       dp[i][j] +=  prevJ;  
                    }
            }
        }
         return dp[m][n];
    }
}
