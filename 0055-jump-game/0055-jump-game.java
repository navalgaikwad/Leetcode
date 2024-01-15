class Solution {
    public boolean canJump(int[] nums) {
        double[] dp = new double[nums.length + 1];
        Arrays.fill(dp, Double.MAX_VALUE);
        dp[0] = 0;
        for(int i =0; i<nums.length; i++) {
            if(dp[i]!=Double.MAX_VALUE) {
               for(int j =0; j<=nums[i]; j++) {
                   int nextPosition = i + j;
                   if(nextPosition < nums.length) {
                       dp[nextPosition] = 1 + dp[i];
                   }
               } 
            }
        }
        System.out.print(dp[nums.length-1]);
        return dp[nums.length-1] == Double.MAX_VALUE? false : true;
    }
}
// int[] dp = new int[nums.length + 1];
//         Arrays.fill(dp, -1);
//         dp[0] = nums[0];
//         int result =0;
//         for(int i =0; i<=nums.length; i++) {
//             if(dp[i] != -1) {
//                 for(int coin =1; coin<=nums[i]; coin++) {
//                     int nextPosition = i + coin;
//                     if(nextPosition < nums.length) {
//                         dp[nextPosition] = nextPosition;
//                     }
//                 }
//             }
//         }
//          return dp[nums.length - 1] == -1? false : true;