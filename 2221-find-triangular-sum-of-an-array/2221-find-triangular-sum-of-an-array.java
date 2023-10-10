class Solution {
    public int triangularSum(int[] nums) {
        int j=1;
        for(int i=0; i<nums.length; i++){
            
            nums= findValue(nums, j);
            j++;
        }
        return nums[0];
    }
    
    int[] findValue(int[] nums, int j){
        int sum=0;
        for(int i=0; i<nums.length-j; i++){
            if(nums[i]+nums[i+1]>=10){
              nums[i]=(nums[i]+nums[i+1])%10;   
            }else{
              nums[i]=(nums[i]+nums[i+1]);
            }
           
        }
        return nums;
    }
}