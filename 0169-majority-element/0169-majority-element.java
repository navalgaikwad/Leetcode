class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int majority = nums[0];
        int len = nums.length;
        int i = 1;
        while(i < len) {
            if(nums[i] != majority) {
                count--;   
            }else {
                count++;
            }
            if(count<= 0) {
                count = 1;
                majority = nums[i];
            }
            i++;
        }
        return majority;
    }
}
//2,2,1,1,1,2,2