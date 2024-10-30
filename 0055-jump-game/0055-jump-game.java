class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for(int i=0; i<nums.length; i++) {
            if(dp[i] != -1) {
                for(int j =1; j<= nums[i]; j++) {
                    int next = i + j;
                    if(next < len) {
                        dp[next] =  dp[i] + 1;
                    }
                }
            }
        }
        return dp[nums.length - 1] != -1; 
    }
}