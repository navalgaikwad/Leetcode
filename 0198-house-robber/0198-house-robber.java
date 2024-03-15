class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len<2){return nums[0];}
        
        int[] dp = new int[len + 1];
        dp[0] = nums[0];
        dp[1] =  Math.max(nums[0], nums[1]);
        for(int i=2; i<len; i++) {
            int previous2 = dp[ i - 2] + nums[i];
            int prev1 = dp[i-1];
            dp[i] = Math.max(previous2, prev1); 
        }
        
        return dp[len-1];
    }
}


//         }
//         int[] dp = new int[n +1];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);