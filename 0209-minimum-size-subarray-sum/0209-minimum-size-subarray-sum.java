class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int j=0;
        for(int i=0; i<nums.length; i++){
            sum =sum+nums[i];
            while(sum >= target){
                len = Math.min(len, i-j+1);
                sum =sum - nums[j];
                j++;
            }
            
        }
        if(len == Integer.MAX_VALUE){
            return 0;
        }
        return len;
    }
}