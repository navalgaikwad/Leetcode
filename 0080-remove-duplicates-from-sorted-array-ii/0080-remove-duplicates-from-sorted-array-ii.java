class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 1;
        int right = 1;
        int count =1;
        while(right < nums.length){
            if(nums[ right ]==nums[right - 1 ]){
                count ++; // macthining increamnent
            }else{
                //if not matching reset it count = 1
                count = 1;
            }
            
            //swap when there is count <=2
            if(count <= 2){
               nums[left++] = nums[right]; 
            }
            right++;
        }
        return left;
    }
}