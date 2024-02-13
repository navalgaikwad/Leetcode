class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        if(nums.length == 0 || nums == null) return;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0 & nums[j]==0){
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
            if(nums[j]!=0){
                j++;
            }
        }
        System.gc();
    }
}