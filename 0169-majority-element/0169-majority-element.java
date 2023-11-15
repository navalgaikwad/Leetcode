class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int result =1;
        for(int i=0; i<nums.length; i++){
            if(maj == nums[i]){
                result++;
            }else{
                result--;
            }
            if(result == 0){
                maj = nums[i];
                result = 1; 
            }
        }
        return maj;
    }
}