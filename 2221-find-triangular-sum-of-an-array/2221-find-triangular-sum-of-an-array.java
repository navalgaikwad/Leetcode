class Solution {
    public int triangularSum(int[] nums) {
        int j =1;
        for(int i=0; i<nums.length; i++) {
            findValue(nums, j++);
        }
        return nums[0];
    }
    
    void findValue(int[] nums, int j) {
        for(int i = 0; i<nums.length - j; i++) {
            int value = nums[i] + nums[i+1];
            if(value >= 10) {
                nums[i] = value%10;
            }else {
                nums[i] = value;
            }
        }
    }
}