class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp ,1);
        
        for(int i=0; i<nums.length; i++) {
            for(int j =0; j < i; j++) {
                int count = dp[j] + 1;
                if(nums[i] > nums[j] && count > dp[i]) {
                    dp[i] = count;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int d : dp) {
            max = Math.max(max, d);
        }
        return max;
    }
}