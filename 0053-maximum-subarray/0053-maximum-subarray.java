class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum =0;
        int left =0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            max = Math.max(max, sum);
            while(sum < 0) {
                sum -=nums[left];
                left++;
            }
        }
        return max;
    }
}