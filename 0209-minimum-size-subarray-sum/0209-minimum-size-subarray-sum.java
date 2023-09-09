class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      //target = 7, nums = [2,3,1,2,4,3]
      //  2
  //l:0,1,2
  //r:1,2,3
  //len:0
  //sum: 2+3=5+1=6+2=8-2=5+4=9-3=6+3=9-1=8-2=6
            int len=Integer.MAX_VALUE;
         int l=0;
        int sum=0;
        for(int r=0;r<nums.length; r++){
            sum=sum+nums[r];
            while(sum>=target){
              sum=sum-nums[l];
              len=Math.min(len, r-l+1);  
                l++;
            }
        }
        if(len==Integer.MAX_VALUE){
            return 0;
        }
         return len;   
    }
}