class Solution {
    public int dominantIndex(int[] nums) {
       int first=-1; int second =-1;  int len = nums.length; int index =-1;
        for(int i=0; i<len; i++){
            if(nums[i]>first){
                second =first;
                first = nums[i];
                index = i;
                
            }
            else if(nums[i]>second){
               second = nums[i];
            }
        }
        return first<2*second?-1:index;
    }
}

//find largest and do half
// check with other element