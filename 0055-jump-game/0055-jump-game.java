class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i= 0; i<=len; i++){
            if(dp[i]){
                for(int coin = 1; coin <=nums[i]; coin++){
                    int nextPosition = i + coin;
                    if(nextPosition < len){
                        dp[nextPosition] = true;
                        if(nextPosition == len - 1){
                            return true;
                        }
                    }
                    
                }
            }
        }
        return dp[len - 1];
    }
}