class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=0; i<=len; i++){
            if(dp[i]!=-1){
                for(int coin = 1; coin<=nums[i]; coin++){
                    
                    int nextPostion = i + coin;
                    if(nextPostion < len){
                        int currentPosition = dp[i];
                        if(dp[nextPostion]==-1 || currentPosition < dp[nextPostion]){
                            dp[nextPostion] = currentPosition + 1;
                        } 
                    }
                    
                }
            }
        }
        return dp[len - 1];
    }
}