class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int count = 1;
        for(int i =0; i<nums.length; i++) {
            if(maj == nums[i]) {
                count++;
            }else {
                count--;
            }
            if(count <= 0) {
                count = 1;
                maj = nums[i];
            }
        }
        return maj;
    }
}