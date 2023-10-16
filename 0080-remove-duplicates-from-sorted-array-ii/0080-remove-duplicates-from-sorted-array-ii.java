class Solution {
    public int removeDuplicates(int[] nums) {
       int left = 0;
        int right = 0;
        int count = 0;
        int len = nums.length;
        while(right < len){
            
                 if(nums[right] != nums[left]){
                left++;
                nums[left] = nums[right];
                count =1;
                     
            }else{
                count ++;
                  if(count == 2){
                       left++;
                       nums[left] = nums[right];
            }   
        }
             
         
            right++;
        }
        return left + 1;  
    }
}

