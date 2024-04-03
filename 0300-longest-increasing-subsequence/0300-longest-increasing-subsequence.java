class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i =0; i<len; i++) {
            for(int j=0; j<i; j++) {
                int count = dp[j] + 1;
                if(nums[i] > nums[j] && dp[i] <count) {
                    dp[i] = count;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i =0; i<len; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}