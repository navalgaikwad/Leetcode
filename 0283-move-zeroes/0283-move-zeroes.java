class Solution {
    public void moveZeroes(int[] nums) {
        int count =0;
        int j =0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        
        for(int k =j; k < nums.length; k++) {
            nums[k] = 0;
        }
        System.gc();
        
    }
}
//take 2 pointer 
//one moving with no another zero
//[0,1,0,3,12]
//[1,1,0,3,12]
//[1,3, 0, 3, 13]
//[1,3,12,3,12]
//j =2 i =4