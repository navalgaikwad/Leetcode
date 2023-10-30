class Solution {
    public int removeElement(int[] nums, int val) {
        int s = 0;
        int e =0;
        int i=0;
        while( i < nums.length){
            if(nums[i]!=val){
                swap(nums, s, e);
                s++;
            }
            e++;
            i++;
            
        }
        return s;
        
    
    }
       void swap(int[] nums,  int s, int e){
            while(s<e){
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
}