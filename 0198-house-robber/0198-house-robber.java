class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len<2){
            return nums[0];
        }
        
        int[] dp = new int[len + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i= 2; i< len; i++){
            int currentRob = nums[i] + dp[i- 2];
            int previousRob = dp[i - 1];
            int profit = Math.max(currentRob, previousRob);
            //System.out.print(profit);
            dp[i] = profit;
        }
        return dp[len-1];
    }
}