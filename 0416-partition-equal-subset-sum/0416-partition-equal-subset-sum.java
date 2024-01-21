class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        
        if(sum % 2 != 0) {
            return false;
        }
        
       
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i=0; i<nums.length; i++) {
            for(int j = sum; j>=nums[i]; j--) {
                boolean take = dp[j];
                boolean notTake = dp[j - nums[i]];
                dp[j] = take || notTake;
            }
        }
        return dp[sum];
    }
}