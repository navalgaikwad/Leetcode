class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for(int i =0 ;i<n; i++) {
            for(int j =0; j<i; j++) {
                int nextCount = dp[j]+ 1;
                if(nums[i] > nums[j] && dp[i] < nextCount) {
                    dp[i]=nextCount;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, dp[i]);
        }
        
        return max;
        
    }
}