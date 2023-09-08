class Solution {
    public int longestSubarray(int[] nums) {
        int zeroS=0;
        int left=0;
        int max=0;
        for(int r=0; r<nums.length; r++){
            if(nums[r]==0){
                zeroS++;
            }
            while(zeroS>1){
                if(nums[left]==0){
                  zeroS--;  
                }
                left++;
            }
            max=Math.max(max, r-left);
            
        }
        return max;
    }
}