class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int len = nums.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<len; i++) {
            if(dp[i]!=Integer.MAX_VALUE) {
                for(int coin=1; coin<=nums[i]; coin++) {
                    int nextPosition = i + coin;
                    if(nextPosition < len) {
                        dp[nextPosition] = 1+ dp[i];
                    }
                }
            }
            
        }
        return dp[len - 1] == Integer.MAX_VALUE ? false : true;
        
    }
}

// [2,3,1,1,4]