class Solution {
    public int countVowelStrings(int n) {
        int[][]dp = new int[n+1][6];
       // dp[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j= 1; j <= 5; j++) {
                dp[i][j] = dp[i][j - 1] + (i-1 > 0 ? dp[i-1][j] : 1); 
            }
        }
        return dp[n][5];
    }
}
//[n+1][6]
                                                                             