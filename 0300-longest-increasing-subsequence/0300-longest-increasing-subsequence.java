class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, 1);
        for(int i=0; i<len; i++) {
            for(int j =0; j<i; j++) {
                int count = dp[j] + 1;
                if(nums[i]> nums[j] && dp[i] < count) {
                    dp[i] = count;
                }
            }
        }
        int max =0;
        
        for(int i=0; i<len; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

//[10,9,2,5,3,7,101,18]
//[     1,2,3,4, 1 , 1]
//10
//9