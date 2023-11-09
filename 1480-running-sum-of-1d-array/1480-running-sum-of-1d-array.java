class Solution {
    public int[] runningSum(int[] nums) {
      int total =0;
        for(int i=0; i<nums.length; i++){
            int value = nums[i];
            total = total + value;
            nums[i] = total;
        }
        return nums;
    }
}