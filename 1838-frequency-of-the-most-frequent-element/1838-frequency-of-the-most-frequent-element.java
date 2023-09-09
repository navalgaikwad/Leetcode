class Solution {
    public int maxFrequency(int[] nums, int k) {
     int left=0;int right=0; int ans=0;
     Arrays.sort(nums);
     long sum=nums[0];
     while(right<nums.length){
        // int max=;
         if((right-left+1)*nums[right]<=k+sum){ //important crux
            ans=Math.max(ans, right-left+1);
              right++;
            if(right<nums.length){
            sum=sum+nums[right];
            }
         }else{
         sum=sum-nums[left];
         left++;
         }
     }
     return ans;  
    }
}