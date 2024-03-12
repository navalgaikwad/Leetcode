class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = nums[0];
        for(int i =0;i <=nums.length; i++) {
            if(dp[i] != Integer.MAX_VALUE) {
                for(int coin =0; coin <=nums[i]; coin++) {
                    int next = i + coin;
                    if(next < nums.length) {
                        dp[next] = Math.min(dp[next], dp[i] + 1);
                    }
                    
                }
            }
        }
        
        return dp[nums.length - 1] == Integer.MAX_VALUE ? false : true; 
    }
    
}