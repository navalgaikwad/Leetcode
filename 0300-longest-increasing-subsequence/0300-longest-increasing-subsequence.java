class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[ len + 1 ];
        Arrays.fill(dp, 1);
        int count = 0;
       
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                int next_count = dp[j] + 1;
                if(nums[i] > nums[j] && dp[i] < next_count) {
                    dp[i] = next_count;
                }
            }
        }
        count =0;
        for(int v : dp) {
           count = Math.max(v, count); 
        }
        return count;
    }
}
