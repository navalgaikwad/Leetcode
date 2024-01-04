class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        int result =0;
        for(int i =0; i<=nums.length; i++) {
            if(dp[i] != -1) {
                for(int coin =1; coin<=nums[i]; coin++) {
                    int nextPosition = i + coin;
                    if(nextPosition < nums.length) {
                        dp[nextPosition] = nextPosition;
                    }
                }
            }
        }
         return dp[nums.length - 1] == -1? false : true;
    }
}

// //nums = [2,3,1,1,4]
//          [2,-1,-1,-1,4]
// max = 2, 3
//     1+3 = 4