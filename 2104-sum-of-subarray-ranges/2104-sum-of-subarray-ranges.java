class Solution {
    public long subArrayRanges(int[] nums) {
        long sum=0;
        for(int i = 0; i < nums.length; ++i){
            long maxVal = nums[i]; long minVal = nums[i];
            for(int j = i; j < nums.length; ++j){
                maxVal = Math.max(nums[j], maxVal);
                minVal = Math.min(nums[j], minVal);
                sum = sum +(maxVal - minVal);
            }
        }
        return sum;
    }
}