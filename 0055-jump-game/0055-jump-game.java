class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for(int i=0; i<=length; i++) {
            if(dp[i] != -1) {
            for(int j=1; j<=nums[i]; j++) {
                int next = j + i;
                if(next < length) {
                    dp[next] = dp[i] + 1;
                }
            }
          }
        }
        return dp[length-1]!=-1;
    }
}