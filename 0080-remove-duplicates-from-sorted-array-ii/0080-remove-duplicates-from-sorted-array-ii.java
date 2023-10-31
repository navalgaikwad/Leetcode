class Solution {
    public int removeDuplicates(int[] nums) {
       int left = 0;
        int right = 0;
        int count = 0;
        int len = nums.length;
        while(right < len){
            //same logic if you find left != right
            if(nums[right] != nums[left]){
                left++;
                nums[left] = nums[right];
                count =1;      
            }else{
                count ++;
                  if(count == 2){
                       left++;
                      //swap everytime when you find counter
                       nums[left] = nums[right];
            }   
        }
        right++;
        }
        return left + 1;  
    }
}

