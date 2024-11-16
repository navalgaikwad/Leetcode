class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for(int i =0;i<=n; i++) {
            
            int left = Math.max(0, i - ranges[i]);//check in left side 
            int right = Math.min(n, i + ranges[i]);//check in right side
            
            for(int start =left; start<=right; start++) {//go from left to right
                dp[right] = Math.min(dp[right], dp[start] + 1); //sames as min coin
            }
               
    }
       
        return dp[n] == (int) 1e9 ? -1 : dp[n];
    }
}