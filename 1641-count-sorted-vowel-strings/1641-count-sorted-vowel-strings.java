class Solution {
    public int countVowelStrings(int n) {
        int[][]dp = new int[n+1][6];
       // dp[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j= 1; j <= 5; j++) {
                int left = 0;
                int right = 1;
                if( j - 1 > 0) {
                    left = dp[i][j - 1];
                }
                if( i - 1 > 0) {
                    right = dp[i-1][j];
                }
                dp[i][j] = left + right; 
            }
        }
        return dp[n][5];
    }
}
//[n+1][6]
                                                                             