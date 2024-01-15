class Solution {
    public int rob(int[] nums) {
       int[] dp = new int[nums.length+1];
        int len = nums.length;
        if(len<2){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2; i<nums.length; i++) {
            int currentHouse = nums[i] + dp[i - 2];
            int previousHouse = dp[i-1];
            dp[i] = Math.max(currentHouse, previousHouse);
        }
        return dp[nums.length-1];
    }
}