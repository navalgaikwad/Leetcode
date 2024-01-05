class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, 1);
        for(int i =0; i < len; i++) {
            for(int j=0; j < i; j++) {
                int next_count = dp[j] + 1;
                if(nums[i] > nums[j] && dp[i] < next_count) {
                    dp[i]  =next_count;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; ++i) {
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
//fill arr with 1
//run for loop on arr length
//inside loop on index till j <i
//check nums[i] > nums[j] and count < nextcount
//then update the dp[i]