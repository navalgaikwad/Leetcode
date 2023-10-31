class Solution {
    public int removeDuplicates(int[] nums) {
       int left = 0;
        int right = 0;
        int count = 0;
        int len = nums.length;
        //1. left and right is not same
        //2. if same
        // 2.1 check for counter == 2
          //2.2 increament left ++
         //2.2 swap left and right
        while(right < len){
            //same logic if you find left != right if you find duplicate
            if(nums[right] != nums[left]){
                left++;
                nums[left] = nums[right];
                count =1;      
            }else{
                count ++;
                  if(count == 2){
                       left++;
                      //swap everytime when you find counter ==2
                       nums[left] = nums[right];
            }
            
        }
        right++;
        }
        return left + 1;  
    }
}

