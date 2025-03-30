class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        for(int i =0; i<nums.length; i++) {
            if(dp[i] != -1) {
                for(int j = 1; j<=nums[i]; j++) {
                    int next = j + i;
                    if(next < n) {
                        dp[next] = dp[i] + 1;
                        if(next == n-1) {
                            return true;
                        }
                    }
                }
            }
        }
         return dp[n - 1] != -1 ? true : false;
    }
}