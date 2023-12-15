class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int len = nums.length;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(int right =0; right < len; right++) {
            sum = sum + nums[right];
            while(sum >= target) {
                result = Math.min(result, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
//             if(sum == target) {
                 
//             }
           
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}