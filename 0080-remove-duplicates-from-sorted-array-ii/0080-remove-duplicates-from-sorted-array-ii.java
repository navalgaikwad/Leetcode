class Solution {
    public int removeDuplicates(int[] nums) {
        int left =1;
        int right = 1;
        int count =1;
        while(right < nums.length){
            if(nums[ right ]==nums[right - 1 ]){
                count ++;
            }else{
                count = 1;
            }
            
            if(count <= 2){
               nums[left++] = nums[right]; 
            }
            right++;
        }
        return left;
    }
}