class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
         if(len<2){
            return nums[0];
        }
        //Arrays.fill(dp , 0);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; i++) {
            int currentRobAndPrevious = nums[i] + dp[i - 2];
            int previous = 0 + dp[i-1];
            dp[i] = Math.max(currentRobAndPrevious, previous);
        }
        
        return dp[len - 1];
    }
}